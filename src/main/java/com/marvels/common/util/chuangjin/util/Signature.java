package com.marvels.common.util.chuangjin.util;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import sun.misc.BASE64Decoder;

/**
 * BairongSignature
 * 签名加密工具�?-�?化版
 *
 * @author zhenzhong.li
 * @date 18/1/4
 */
public class Signature {
    private static final String charset = "utf-8";
    private static final String signTypeSHA1 = "SHA1withRSA";
    private static final String signTypeSHA256 = "SHA256withRSA";
    private static final String signTypeMD5 = "MD5withRSA";
    //AES_256_cbc pkcs7
    private static final String algorithm = "AES/CBC/PKCS5Padding";


    /**
     * 加签
     *
     * @param signParams
     * @param privateKey
     * @return
     */
    public static String signMD5(Map<String, String> signParams, String privateKey) {
        return initSign(signTypeMD5, signParams, privateKey);
    }

    public static String signSHA1(Map<String, String> signParams, String privateKey) {
        return initSign(signTypeSHA1, signParams, privateKey);
    }

    public static String signSHA256(Map<String, String> signParams, String privateKey) {
        return initSign(signTypeSHA256, signParams, privateKey);
    }

    /**
     * 根据类型生成签名
     *
     * @param privateKey
     */
    private static String initSign(String signType, Map<String, String> signParams, String privateKey) {
        try {
            String content = getSignContent(signParams);
            PrivateKey priKey = getPrivateKeyFromPKCS8(privateKey);
            java.security.Signature signature = java.security.Signature.getInstance(signType);
            signature.initSign(priKey);
            if (isEmpty(charset)) {
                signature.update(content.getBytes());
            } else {
                signature.update(content.getBytes(charset));
            }
            byte[] signed = signature.sign();
            return new String(Base64.encode(signed));
        } catch (Exception e) {
            System.out.println("生成签名异常:" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 验证签名
     *
     * @param signParams
     * @param sign
     * @param publicKey
     * @return
     */
    public static boolean checkSignMD5(Map<String, String> signParams, String sign, String publicKey) {
        return rsa256CheckContent(signTypeMD5, signParams, sign, publicKey);
    }

    public static boolean checkSignSHA1(Map<String, String> signParams, String sign, String publicKey) {
        return rsa256CheckContent(signTypeSHA1, signParams, sign, publicKey);
    }

    public static boolean checkSignSHA256(Map<String, String> signParams, String sign, String publicKey) {
        return rsa256CheckContent(signTypeSHA256, signParams, sign, publicKey);
    }

    /**
     * 根据加签类型验证签名
     *
     * @param signParams
     * @param sign
     * @param publicKey
     * @return
     */
    private static boolean rsa256CheckContent(String signType, Map<String, String> signParams, String sign, String publicKey) {
        try {
            String content = getSignContent(signParams);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            java.security.Signature signature = java.security.Signature.getInstance(signType);

            signature.initVerify(pubKey);
            signature.update(content.getBytes(charset));
            boolean bverify = signature.verify(Base64.decode(sign));
            return bverify;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * RSA-公钥加密过程
     *
     * @param params
     * @param pubKey
     * @return
     * @throws Exception
     */
    public static String encryptRSA(Map<String, String> params, String pubKey) throws Exception {
        if (isEmpty(pubKey)) {
            throw new Exception("加密公钥为空, 请设�?");
        }
        String context = getSignContent(params);
        PublicKey publicKey = getPublicKeyFromX509(pubKey);
        Cipher cipher;
        try {
            // 使用默认RSA
            cipher = Cipher.getInstance("RSA");
            // cipher= Cipher.getInstance("RSA", new BouncyCastleProvider());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(context.getBytes());
            return Base64.encode(output);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("加密公钥非法,请检�?");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("明文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("明文数据已损�?");
        }
    }

    /**
     * RSA-私钥解密过程
     *
     * @param context
     * @param priKey
     * @return
     * @throws Exception
     */
    public static String decryptRSA(String context, String priKey) throws Exception {
        if (isEmpty(priKey)) {
            throw new Exception("解密私钥为空, 请设�?");
        }
        PrivateKey privateKey = getPrivateKeyFromPKCS8(priKey);
        Cipher cipher;
        try {
            // 使用默认RSA
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] output = cipher.doFinal(Base64.decode(context));
            return new String(output);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("解密私钥非法,请检�?");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("密文长度非法");
        } catch (BadPaddingException e) {
            throw new Exception("密文数据已损�?");
        }
    }

    /**
     * 参数格式转换Map转String
     *
     * @param sortedParams
     * @return
     */
    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = sortedParams.get(key);
            if (isNotEmpty(key) && isNotEmpty(value)) {
                content.append((index == 0 ? "" : "&") + key + "=" + value);
                index++;
            }
        }
        return content.toString();
    }


    /**
     * 私钥对象生成
     *
     * @param priKey
     * @return
     * @throws Exception
     */
    private static PrivateKey getPrivateKeyFromPKCS8(String priKey) throws Exception {
        PKCS8EncodedKeySpec priPKCS8;
        PrivateKey privateKey = null;
        if (isEmpty(priKey)) {
            return privateKey;
        }
        try {
            priPKCS8 = new PKCS8EncodedKeySpec(new BASE64Decoder().decodeBuffer(priKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            privateKey = keyf.generatePrivate(priPKCS8);
        } catch (Exception e) {
            System.out.println("私钥解析错误:" + e.getMessage());
        }
        return privateKey;
    }

    /**
     * 公钥对象生成
     *
     * @param pubKey
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKeyFromX509(String pubKey) throws Exception {
        PublicKey publicKey = null;
        if (isEmpty(pubKey)) {
            return publicKey;
        }
        try {
            java.security.spec.X509EncodedKeySpec bobPubKeySpec = new java.security.spec.X509EncodedKeySpec(
                    new BASE64Decoder().decodeBuffer(pubKey));
            java.security.KeyFactory keyFactory;
            keyFactory = java.security.KeyFactory.getInstance("RSA");
            // 取公钥匙对象
            publicKey = keyFactory.generatePublic(bobPubKeySpec);
        } catch (Exception e) {

        }
        return publicKey;
    }

    /**
     * AES加密
     *
     * @param base64Key
     * @param text
     * @return
     * @throws Exception
     */
    public static String encryptAES(String base64Key, String text) {
        try {
            byte[] key = parseHexStr2Byte(base64Key);
            SecretKeySpec sKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
            byte[] encryptBytes = cipher.doFinal(text.getBytes(charset));
            return parseByte2HexStr(encryptBytes);
        } catch (Exception e) {
            System.out.println("AES加密错误:" + e.getMessage());
        }
        return null;
    }

    /**
     * AES解密
     *
     * @param base64Key
     * @param text
     * @return
     * @throws Exception
     */
    public static String decryptAES(String base64Key, String text) {
        try {
            byte[] key = parseHexStr2Byte(base64Key);
            SecretKeySpec sKeySpec = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec);
            byte[] decryptBytes = cipher.doFinal(parseHexStr2Byte(text));
            return new String(decryptBytes, "UTF-8");
        } catch (Exception e) {
            System.out.println("AES解密错误:" + e.getMessage());
        }
        return null;
    }

    /**
     * �?16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 将二进制转换�?16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }


    private static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    private static boolean isNotEmpty(String str) {
        return ((str != null) && (str.length() > 0));
    }


    public static void main(String[] arg) {
        //--------生成RSA秘钥�?--------
     /*   System.out.println("********create RSA keys********");*/
        Map map = CreateKeys.getRSAKey();
        //公钥
        String pubKey = map.get("pubKey").toString();
        System.out.println("RSA pubKey:" + pubKey);
        //私钥
        String priKey = map.get("priKey").toString();
        System.out.println("RSA priKey:" + priKey);


  /*      //--------RSA 加签--------
        System.out.println("********RSA create sign ********");
        //加签参数
        Map param = new HashMap();
        param.put("appId", "10001");
        param.put("timestamp", "112512912312");
        param.put("request", "{\"name\":\"xxxxx\", \"phone\":\"000181919199191\"}");
        //生成签名字符�?
        System.out.println("sign param :" + BairongSignature.getSignContent(param));
        String signStr = BairongSignature.signSHA256(param, priKey);
        System.out.println("sign str :" + signStr);
        param.put("sign", signStr);*/

        //--------RSA 验证--------
       /* System.out.println("********RSA check sign ********");
        String singStr1 = null;//(String) param.get("sign");
        singStr1="s0BRrt5SWyWkhbzMiyIZqnpfAj12624iD+0rKHmXLM0YqVsZmXEWea+dz4OivD2iNWuE7wf6ywWGdQ3nmRQZDEqFpNbEAmeyEYuiL49nMxepxoASabh5vmkv8QsggSTLbYsUc/tkdNyy0FQFH5bY584f9FLujdFh3jkBwMODduY=";
        //获取验证参数,与加签一�?
        Map param1 = new HashMap();
        param1.put("appId", "10001");
        param1.put("timestamp", "112512912312");
        param1.put("request", "1D6AFF590443C948DF626DA69B56F4751B038C39135B5654A22128BD89DCE2711E900EBFE59C9355BC810F74D8EAC7DD");
        //System.out.println("check sign param :" + BairongSignature.getSignContent(param1));
        boolean flag = BairongSignature.checkSignSHA1(param1, singStr1, pubKey);
        System.out.println("check sign flag:" + flag);

        String aeskey = "4FE8645B8EAF88EA0ADADA6FAEDD3A29";
        String decoded = BairongSignature.decryptAES(aeskey, "1D6AFF590443C948DF626DA69B56F4751B038C39135B5654A22128BD89DCE2711E900EBFE59C9355BC810F74D8EAC7DD");
        System.out.println("解密报文:" + decoded);*/
        //--------RSA 加解�?--------
       /* System.out.println("********RSA encrypt/decrypt ********");
        Map param2 = new HashMap();
        param2.put("user", "123");
        param2.put("time", "123431123");
        param2.put("context", "ssdad212e12fdasda");
        System.out.println("rsa param:" + BairongSignature.getSignContent(param2));
        try {
            //加密
            String enStr = BairongSignature.encryptRSA(param2, pubKey);
            System.out.println("rsa encrypt:" + enStr);

            //解密
            String deStr = BairongSignature.decryptRSA(enStr, priKey);
            System.out.println("rsa decrypt:" + deStr);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //--------AES 加解�?----------
        System.out.println("********AES encrypt/decrypt ********");
        //加密字符�?
        String content = "hello world";
        //生成AES秘钥
        String aeskey = CreateKeys.getAESKey();
        System.out.println("AES KEY:" + aeskey);

        //发�?��?�加�?
        System.out.println("encrypt param:" + content);
        String encode = BairongSignature.encryptAES(aeskey, content);
        System.out.println("encrypt :" + encode);

        //接收者解�?
        encode = "xsadadadasdassadasdasa";
        String decoded = BairongSignature.decryptAES(aeskey, encode);
        System.out.println("decrypt :" + decoded);*/
    }
}
