package com.marvels.common.util.hexj.demo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marvels.common.util.hexj.bean.HaiercashPayApplyBean;
import com.marvels.common.util.hexj.utils.HttpClient;
import com.marvels.common.util.hexj.utils.RSAUtils;
import com.marvels.common.util.hexj.utils.SignUtils;

/**
 * Created by lishidong on 2018/10/19.
 */
public class ChannelReqToHaier {
    /**
     * 海尔消金提供给渠道方的验签公钥，与HaierRespToChannel.java中的私钥（hexjSignPrivateKey）配对
     * 以实际提供为准
     */
    //维信
    private final static String hexjSignPublicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMvPRJJ8+gd4/QEMhs/kyGUKH5oyoMXDAnMa6tkkknOAYwkvf7BCDR+trDUFC5puz4u8F4bqL0z33zJDyaSKU+MCAwEAAQ==";

    /**
     * 渠道方自己生成的的签名私钥，与HaierRespToChannel.java中的私钥（channelSignPublicKey）配对
     * 以实际提供为准 B7
     */
    //维信
    private final static String channelSignPrivateKey = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAi/Bdw8VVwQCYwuUIyJwcbI8R15Hp8+lXC4Os4reJYrm6ptUOLKAxANr/bkIvLl6OUBMUyl5k4SFCjEuG4CyeiQIDAQABAkB0HRcAOT5FbeRTWs2l/3rKTRBF6anRHF2AjVqnqBjUFAPtPTpn7fFjHTx+KKfE6ZaPwt0zcUzl7a5SfcX0X6TxAiEAwfAyCp3zOZRjsZwEv1VkSrJAjQgH178NASaUNburUEUCIQC4uHBoZUA+0gW1hBFkWnh5rsqowjfRXY2we+5nhIGjdQIhAI69p1dBIf/DRA05dBUPWJ3RzMkAnCUjLQMnzfYuhsyxAiAszF5GkzevhJPp36uwINjS+fcgUmnjFsNEJ+o7pMEj+QIgKwqaq03jDa1wZCHG+78sRTDH5rE1RW9P4h6ZBaDSnfM=";

    /**
     * 以 额度申请提交接口 为例
     */
    public static void main(String[] args) throws Exception {
        StringBuffer lineTxt = new StringBuffer();
        String linetxttmp = new String();
        try {
            String encoding = "UTF-8";
            File file = new File("src/main/file/MyDemo.txt");
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                while ((linetxttmp = bufferedReader.readLine()) != null) {
                    lineTxt.append(linetxttmp);
                }
                read.close();
                System.out.println(lineTxt.toString());
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        HaiercashPayApplyBean reqBdoyBean = new HaiercashPayApplyBean();
        reqBdoyBean.setApplyNo("20181020412201429512486912");
        reqBdoyBean.setChannelNo("B6");
        reqBdoyBean.setTradeCode("LP20005");
        String data = lineTxt.toString();//json格式的请求数据
        //String data = "{\"head\":{\"tradeCode\":\"CP020\",\"serno\":\" 20181020412201429512486912\",\"sysFlag\":\"11\",\"tradeDate\":\"2018-10-20\",\"tradeTime\":\"12:33:44\",\"channelNo\":\"A2\"},\"body\":{\"typGrp\":\"02\",\"custNo\":\"C201811080520301377520\"}}";
        reqBdoyBean.setData(data);
        //请求海尔消金接口
        //10.166.102.78 localhost testpm.haiercash.com
        String ip = "testpm.haiercash.com";
        String port = ":9002";
        //ACQ-2202
        //String application = "HaiercashPayApplyForJson";
        //还款计划查询
        //String application = "queryApplLoanReraidPlanByloanNoOrderByDate";
        //测试方法queryApplLoanReraidPlanByloanNoOrderByDate
        //credit loan repay common
        String application = "loan/LP20005";
        String url = "http://" + ip + port + "/hrlp/" + application;
        //"10.164.197.48"
        //先做加密，对reqBdoyBean中的data加密后
        String encryptDate = RSAUtils.encryptRSA(reqBdoyBean.getData(), channelSignPrivateKey);
        reqBdoyBean.setData(encryptDate);
        //再做签名操作,签名信息存放header的X-Signature中,再网络发送
        String signStr = SignUtils.sign(new ObjectMapper().writeValueAsString(reqBdoyBean), channelSignPrivateKey);
        System.out.println("发送签名：" + signStr);
        System.out.println("发送申请：" + new ObjectMapper().writeValueAsString(reqBdoyBean));


        String requestBodyStr = new ObjectMapper().writeValueAsString(reqBdoyBean);
        //发送 body信息 和 签名信息;[X-Signature]
        String resp = HttpClient.sendJson(url, signStr, requestBodyStr);
        String[] reqSignStr = resp.split("&&");
        System.out.println("渠道接收：" + reqSignStr[0]);
        System.out.println("返回签名：" + reqSignStr[1]);
        //用于海尔消金返回的数据进行验签
        if (!SignUtils.verify(reqSignStr[0], hexjSignPublicKey, reqSignStr[1])) {
            throw new RuntimeException("验签失败");
        } else {
            System.out.println("海尔返回信息，验签成功！");
        }

        JSONObject jsonObject = JSON.parseObject(reqSignStr[0]);
        //解密
        String decryptData = "";
        if (jsonObject.containsKey("body")) {
            String bodyData = jsonObject.getString("body");
            if (StringUtils.isNotEmpty(bodyData)) {
                decryptData = RSAUtils.decryptRSA(bodyData, hexjSignPublicKey);
            }
        }

        System.out.println("渠道接收解密数据：" + decryptData);

    }
}
