package com.marvels.common.util.hexj.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.FileImageOutputStream;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marvels.common.util.hexj.bean.DownFileBean;
import com.marvels.common.util.hexj.bean.HaiercashPayApplyBean;
import com.marvels.common.util.hexj.utils.EncryptUtil;
import com.marvels.common.util.hexj.utils.HttpClient;
import com.marvels.common.util.hexj.utils.RSAUtils;
import com.marvels.common.util.hexj.utils.SignUtils;

import sun.misc.BASE64Decoder;

/**
 * 文件下载测试类
 * Created by
 */
public class Download {
    private static final ThreadLocal<BASE64Decoder> BASE64_DECODER = new ThreadLocal<BASE64Decoder>();
    /**
     * 海尔消金提供给渠道方的验签公钥，与HaierRespToChannel.java中的私钥（hexjSignPrivateKey）配对
     * 以实际提供为准
     */
    //维信
    private final static String hexjSignPublicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKwVdPSlL9wvDzcEaukDkI1xIJ8G+9Sx4BXmCYNfS0nZvCmkRTHRtHoYWwOU1w33BQgBHlhoNL3sVUtN+81Hw90CAwEAAQ==";

    /**
     * 渠道方自己生成的的签名私钥，与HaierRespToChannel.java中的私钥（channelSignPublicKey）配对
     * 以实际提供为准 B7
     */
    //维信
    private final static String channelSignPrivateKey = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAvv7+68/rX4s1XC+AlyglvGJGtof7m7HmM5wwkynQLlhTnd+VQCvt25Itx4wkDTQON/3Ay+Tpayq1zJf8tgp1dwIDAQABAkBlUcRNuBi2sJR3+MMQbL3H96Jnhi+VYoQp8Ltb9hx32HyyD3NnwMD1j4s6157ePg0mxjoqxW4GBslOviDRdq9RAiEA4E8PQKGdc5Cj+KaIupQayiLs5rAGCN5xEETW/ITs/G0CIQDZ+w9hgumpiOInrippTB2V3sHR3n3GphvOowwY3NYC8wIgKosUK3/7qwWN9AUx/aFFi30gTYipPFlkPF+yHubfQ+kCICkqsf/vcmOTN2rZCKd0OY4pUJ9rDoPqsQu4XTuA0WYjAiBdOp9WZYPUvgirTR0eQsa1/BH3bgWUmmWvTDMY5I5FUQ==";

    /**
     * 以 额度申请提交接口 为例
     */
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        //testpm.haiercash.com:9002   localhost:8070
        String ip = "testpm.haiercash.com:9002";
        String url = "http://" + ip + "/hrlp/common/LP40003";
        HaiercashPayApplyBean reqBdoyBean = new HaiercashPayApplyBean();
        reqBdoyBean.setApplyNo("20181020412201429512486912");
        reqBdoyBean.setChannelNo("E8");
        reqBdoyBean.setTradeCode("LP40003");
        DownFileBean downFileBean = new DownFileBean();
        downFileBean.setAppno("20181126095010");//201607281234
        downFileBean.setAppl(""); //申请流水号
        downFileBean.setApptime("20190510102718"); //按照日期找文件路径  CA  201802024500892
        downFileBean.setChannelNo("E8");//渠道号
        downFileBean.setFileType("ROLL"); //文件下载 CA
        //先做签名操作,签名信息存放header的X-Signature中
        String requestData = RSAUtils.encryptRSA(objectMapper.writeValueAsString(downFileBean), channelSignPrivateKey);
        reqBdoyBean.setData(requestData);
        String signStr = SignUtils.sign(objectMapper.writeValueAsString(reqBdoyBean), channelSignPrivateKey);
        String json = new ObjectMapper().writeValueAsString(reqBdoyBean);
        System.out.println("发送签名：" + signStr);
        System.out.println("请求数据：" + json);
        String resp = HttpClient.sendJson(url, signStr, json);

        String[] reqSignStr = resp.split("&&");
        System.out.println("渠道接收：" + reqSignStr[0]);
        System.out.println("返回签名：" + reqSignStr[1]);

        if (!SignUtils.verify(reqSignStr[0], hexjSignPublicKey, reqSignStr[1])) {
            throw new RuntimeException("验签失败");
        } else {
            System.out.println("海尔返回信息，验签成功！");
        }

        byte[] bytes;
        String decryptData = "";
        //解密
        JSONObject object = JSONObject.parseObject(reqSignStr[0]);
        String bodyData = object.getString("body");
        if (StringUtils.isNotEmpty(bodyData)) {
            decryptData = RSAUtils.decryptRSA(bodyData, hexjSignPublicKey);

            System.out.println("解密后报文：" + decryptData);

            List list = JSONObject.parseArray(decryptData);
            Map<String, String> map = (Map<String, String>) list.get(0);
            String fileString = map.get("file");
            String md5 = map.get("md5");

            bytes = BASE64_DECODER.get().decodeBuffer(fileString);
            File file = new File("E:/downtest/up.txt");
            FileImageOutputStream outputStream = new FileImageOutputStream(file);
            FileInputStream is = new FileInputStream(file);
            outputStream.write(bytes, 0, bytes.length);
            outputStream.close();
            System.out.println("+++++++++++++++下载完毕+++++++++++++++++++++");
            String myMd5 = multipart2File(is);
            if (myMd5 == null) {
                System.out.println("md5文件串生成失败");
            }
            if (md5.equals(myMd5)) {
                System.out.println("md5文件串验证一致 ");
            }
        }

    }


    /**
     * 根据文件流，生成MD5码
     *
     * @param
     * @param
     * @param
     * @return MD5码，失败返回null
     */
    private static String multipart2File(InputStream stream) {
        String myMd5;
        try {
            byte[] buffer = new byte[1024 * 1024];
            int byteRead;
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            while ((byteRead = stream.read(buffer)) != -1) {
                messagedigest.update(buffer, 0, byteRead);
            }
            myMd5 = EncryptUtil.MD5(messagedigest.digest());
            return myMd5;
        } catch (IOException e) {

            return null;
        } catch (NoSuchAlgorithmException e) {

            return null;
        }
    }
}
