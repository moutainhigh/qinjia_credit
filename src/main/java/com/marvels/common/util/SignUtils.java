package com.marvels.common.util;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by lishidong on 2018/10/19.
 */
public class SignUtils {

    /**
     * 哈希算法
     */
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /**
     * 加解密算法
     */
    public static final String KEY_ALGORITHM = "RSA";

    /**
     *
     * @param data 传输信息
     * @param privateKey 双方持有的签名私钥 base64编码
     */
    public static String sign(String data, String privateKey) {
        try {
            //base64解码签名私钥
            byte[] keyBytes = Base64.decodeBase64(privateKey);

            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(data.getBytes("UTF-8"));
            return Base64.encodeBase64String(signature.sign());
        } catch (Exception e) {
            throw new RuntimeException("RSA签名异常.", e);
        }
    }

    /**
     * @param data 传输数据
     * @param publicKey 由对方提供的签名公钥 base64编码
     * @param sign 签名信息 base64编码
     * @return
     */
    public static boolean verify(String data, String publicKey, String sign) {
        try {
            //base64解码验签公钥
            byte[] keyBytes = Base64.decodeBase64(publicKey);

            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PublicKey pubKey = keyFactory.generatePublic(keySpec);

            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initVerify(pubKey);
            signature.update(data.getBytes());
            return signature.verify(Base64.decodeBase64(sign));
        } catch (Exception e) {
            throw new RuntimeException("RSA验证签名异常.", e);
        }
    }

}
