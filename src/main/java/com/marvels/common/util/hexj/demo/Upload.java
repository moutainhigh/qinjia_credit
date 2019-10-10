package com.marvels.common.util.hexj.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.lang3.CharUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marvels.common.util.hexj.bean.CharSequenceIterable;
import com.marvels.common.util.hexj.bean.HaiercashPayApplyBean;
import com.marvels.common.util.hexj.bean.ImageUploadPO;
import com.marvels.common.util.hexj.bean.ImageUploadVO;
import com.marvels.common.util.hexj.utils.EncryptUtil;
import com.marvels.common.util.hexj.utils.HttpClient;
import com.marvels.common.util.hexj.utils.SignUtils;

import sun.misc.BASE64Encoder;

public class Upload {
	
	private static Logger logger = Logger.getLogger(Upload.class);

    private static final ThreadLocal<BASE64Encoder> BASE64_ENCODER = new ThreadLocal<BASE64Encoder>();
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

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] data;
        FileImageInputStream input;
        try {
            input = new FileImageInputStream(new File("C:\\Users\\jason\\Desktop\\1.png"));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
            HaiercashPayApplyBean reqBdoyBean = new HaiercashPayApplyBean();
            reqBdoyBean.setApplyNo("20181020412201429512486912");
            reqBdoyBean.setChannelNo("E8");
            reqBdoyBean.setTradeCode("LP40002");
            //base64文件流
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String request = base64Encoder.encode(data);
            InputStream inputStream = new ByteArrayInputStream(output.toByteArray());
            String myMd5 = multipart2File(inputStream);
            ImageUploadPO imagePO = new ImageUploadPO();
            imagePO.setChannelNo("E8");//渠道编码
            imagePO.setAppl("");// 申请流水号12028629
            imagePO.setAppno("jfkdjhrurifjgh");// 贷款编号
            imagePO.setApptime("20190426050080");// 申请时间
            ImageUploadVO imageVO = new ImageUploadVO();
            imageVO.setFile(request);
            imageVO.setFilename("2019-04-26_3222_001_DL.txt");// 文件名
            imageVO.setFileoper("0");// 类型 新增
            imageVO.setFileType("DL");// 文件类型
            imageVO.setMd5(myMd5);
            List list = new ArrayList();
            list.add(imageVO);
            imagePO.setFilelist(list);
            String requestData = objectMapper.writeValueAsString(imagePO);
            reqBdoyBean.setData(requestData);
            String requestJson = objectMapper.writeValueAsString(reqBdoyBean);
            System.out.println("加签报文： " + requestJson);
            //先做签名操作,签名信息存放header的X-Signature中
            String signStr = SignUtils.sign(requestJson, channelSignPrivateKey);
            System.out.println("签名信息：" + signStr);
            //localhost testpm.haiercash.com
            String url = "http://testpm.haiercash.com:9002/hrlp/common/LP40002";
            //发送 body信息 和 签名信息;[X-Signature]
            String resp = HttpClient.sendJson(url, signStr, requestJson);
            String[] reqSignStr = resp.split("&&");
            System.out.println("渠道接收信息：" + reqSignStr[0]);
            System.out.println("接收签名信息：" + reqSignStr[1]);
            if (!SignUtils.verify(reqSignStr[0], hexjSignPublicKey, reqSignStr[1])) {
                throw new RuntimeException("验签失败");
            } else {
                System.out.println("海尔返回信息，验签成功！");
            }

        } catch (Exception e) {
        	logger.error("上传失败",e);
        } finally {

        }


    }


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
            stream.close();
            return myMd5;
        } catch (IOException e) {
            return null;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static byte[] compress(byte[] buffer) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
                gzipOutputStream.write(buffer);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String stripNewLine(String value) {
        if (value == null || value.length() == 0)
            return value;
        StringBuilder builder = new StringBuilder(value.length());
        for (char c : new CharSequenceIterable(value)) {
            switch (c) {
                case CharUtils.CR:
                case CharUtils.LF:
                    break;
                default:
                    builder.append(c);
                    break;
            }
        }
        return builder.toString();
    }


}
