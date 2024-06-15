package org.chenqingci.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @Description
 * @Author 陈佳豪
 * @Date 2024/6/6
 * @Year 2024
 */
public class DruidEncrypUtils {
    private static String publicKey;
    private static String privateKey;
    static {
        try {
            String[] keyPair = ConfigTools.genKeyPair(512);
            privateKey = keyPair[0];
            publicKey = keyPair[1];
            System.out.println("publicKey: " + publicKey);
            System.out.println("privateKey: " + privateKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }
    public static String encrypt(String plainText) throws Exception {
        String encrypt = ConfigTools.encrypt(privateKey, plainText);
        System.out.println("encrypt: " + encrypt);
        return encrypt;
    }
    public static String decrypt(String cipherText) throws Exception {
        String decrypt = ConfigTools.decrypt(publicKey, cipherText);
        System.out.println("decrypt: " + decrypt);
        return decrypt;
    }

    public static void main(String[] args) throws Exception {
        String encrypt = encrypt("202213");
    }
}
