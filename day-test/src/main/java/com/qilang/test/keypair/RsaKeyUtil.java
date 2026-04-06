package com.qilang.test.keypair;

import com.alibaba.fastjson.JSON;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

public class RsaKeyUtil {
    private static final String ALGORITHM = "RSA";
    private static final int KEY_SIZE = 2048;
    private static final String TRANSFORMATION = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /**
     * 生成RSA密钥对
     * @return 包含公钥和私钥的Map
     */
    public static Map<String, String> generateKeyPair() throws Exception {
        return generateKeyPair(KEY_SIZE);
    }

    /**
     * 生成RSA密钥对
     * @param keySize 密钥长度
     * @return 包含公钥和私钥的Map
     */
    public static Map<String, String> generateKeyPair(int keySize) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(keySize);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        Map<String, String> keyPairMap = new HashMap<>();
        keyPairMap.put("publicKey", base64Encode(publicKey.getEncoded()));
        keyPairMap.put("privateKey", base64Encode(privateKey.getEncoded()));

        return keyPairMap;
    }

    /**
     * 生成PEM格式的密钥对
     */
    public static Map<String, String> generateKeyPairPem() throws Exception {
        Map<String, String> keyPair = generateKeyPair();

        String publicKeyPem = convertToPem(keyPair.get("publicKey"), "PUBLIC");
        String privateKeyPem = convertToPem(keyPair.get("privateKey"), "PRIVATE");

        Map<String, String> pemKeyPair = new HashMap<>();
        pemKeyPair.put("publicKey", publicKeyPem);
        pemKeyPair.put("privateKey", privateKeyPem);

        return pemKeyPair;
    }

    /**
     * 使用公钥加密
     * @param data 要加密的数据
     * @param publicKeyBase64 Base64编码的公钥
     * @return Base64编码的加密数据
     */
    public static String encrypt(String data, String publicKeyBase64) throws Exception {
        return encrypt(data, publicKeyBase64, false);
    }

    /**
     * 使用公钥加密
     * @param data 要加密的数据
     * @param publicKeyBase64 Base64编码的公钥
     * @param isPem 是否为PEM格式
     * @return Base64编码的加密数据
     */
    public static String encrypt(String data, String publicKeyBase64, boolean isPem) throws Exception {
        // 如果是PEM格式，提取Base64部分
        String keyBase64 = isPem ? extractBase64FromPem(publicKeyBase64) : publicKeyBase64;
        // 解码Base64公钥
        byte[] keyBytes = base64Decode(keyBase64);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        // 创建加密器
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        // 加密数据
        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * 使用私钥解密
     * @param encryptedDataBase64 Base64编码的加密数据
     * @param privateKeyBase64 Base64编码的私钥
     * @return 解密后的原始数据
     */
    public static String decrypt(String encryptedDataBase64, String privateKeyBase64) throws Exception {
        return decrypt(encryptedDataBase64, privateKeyBase64, false);
    }

    /**
     * 使用私钥解密
     * @param encryptedDataBase64 Base64编码的加密数据
     * @param privateKeyBase64 Base64编码的私钥
     * @param isPem 是否为PEM格式
     * @return 解密后的原始数据
     */
    public static String decrypt(String encryptedDataBase64, String privateKeyBase64, boolean isPem) throws Exception {
        // 如果是PEM格式，提取Base64部分
        String keyBase64 = isPem ? extractBase64FromPem(privateKeyBase64) : privateKeyBase64;

        // 解码Base64私钥
        byte[] keyBytes = base64Decode(keyBase64);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        // 解码加密数据
        byte[] encryptedBytes = base64Decode(encryptedDataBase64);
        // 创建解密器
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        // 解密数据
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

   /* *//**
     * 使用私钥签名
     *//*
    public static String sign(String data, String privateKeyBase64) throws Exception {
        return sign(data, privateKeyBase64, false);
    }*/

    public static String sign(String data, String privateKeyBase64, boolean isPem) throws Exception {
        String keyBase64 = isPem ? extractBase64FromPem(privateKeyBase64) : privateKeyBase64;
        byte[] keyBytes = base64Decode(keyBase64);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes(StandardCharsets.UTF_8));
        byte[] signatureBytes = signature.sign();
        return Base64.getEncoder().encodeToString(signatureBytes);
    }

    /**
     * 使用公钥验证签名
     */
    public static boolean verify(String data, String signatureBase64, String publicKeyBase64) throws Exception {
        return verify(data, signatureBase64, publicKeyBase64, false);
    }

    public static boolean verify(String data, String signatureBase64, String publicKeyBase64, boolean isPem) throws Exception {
        String keyBase64 = isPem ? extractBase64FromPem(publicKeyBase64) : publicKeyBase64;
        byte[] keyBytes = base64Decode(keyBase64);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(data.getBytes(StandardCharsets.UTF_8));

        byte[] signatureBytes = base64Decode(signatureBase64);
        return signature.verify(signatureBytes);
    }

    /**
     * 从PEM格式中提取Base64部分
     */
    private static String extractBase64FromPem(String pem) {
        return pem.replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");
    }

    /**
     * 转换为PEM格式
     */
    private static String convertToPem(String base64Key, String type) {
        StringBuilder pem = new StringBuilder();
        pem.append("-----BEGIN ").append(type).append(" KEY-----\n");

        // 每64个字符换行
        for (int i = 0; i < base64Key.length(); i += 64) {
            int end = Math.min(i + 64, base64Key.length());
            pem.append(base64Key, i, end).append("\n");
        }

        pem.append("-----END ").append(type).append(" KEY-----\n");
        return pem.toString();
    }

    private static String base64Encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    private static byte[] base64Decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    /**
     * 测试示例
     */
    public static void main(String[] args) {
        try {
            System.out.println("=== 生成RSA密钥对 ===");
            Map<String, String> keyPair = generateKeyPair();

            String publicKey = keyPair.get("publicKey");
            String privateKey = keyPair.get("privateKey");

            System.out.println("公钥(Base64): " + publicKey);
            System.out.println("私钥(Base64): " + privateKey);

        /*    // 生成PEM格式
            Map<String, String> pemKeyPair = generateKeyPairPem();
            System.out.println("\n公钥(PEM):\n" + pemKeyPair.get("publicKey"));
            System.out.println("私钥(PEM):\n" + pemKeyPair.get("privateKey"));*/

            // 测试加密解密
            System.out.println("\n=== 测试加密解密 ===");
            List<String> list = new ArrayList<>();
            list.add("1");list.add("2");list.add("3");
            String originalData = JSON.toJSONString(list);
            System.out.println("原始数据: " + originalData);

            // 使用公钥加密
            String encryptedData = encrypt(originalData, publicKey);
            System.out.println("加密后(Base64): " + encryptedData);

            // 使用私钥解密
            String decryptedData = decrypt(encryptedData, privateKey);
            System.out.println("解密后: " + decryptedData);

            // 测试签名验证
         /*   System.out.println("\n=== 测试签名验证 ===");
            String dataToSign = "需要签名的数据";*/

          /*  // 使用私钥签名
            String signature = sign(dataToSign, privateKey);
            System.out.println("签名(Base64): " + signature);

            // 使用公钥验证签名
            boolean isValid = verify(dataToSign, signature, publicKey);
            System.out.println("签名验证结果: " + isValid);

            // 测试修改数据后的验证
            boolean isTampered = verify("被篡改的数据", signature, publicKey);
            System.out.println("篡改后验证结果: " + isTampered);*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
