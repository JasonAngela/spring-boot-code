package com.qilang.test;

import java.security.*;
import java.util.Base64;

public class RSAKeyGenerator {
    public static void main(String[] args) {
        try {
            // 生成RSA密钥对
            KeyPair keyPair = generateRSAKeyPair(2048);

            // 获取公钥和私钥
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // 将密钥转换为Base64字符串便于查看和存储
            String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            String privateKeyBase64 = Base64.getEncoder().encodeToString(privateKey.getEncoded());

            // 输出结果
            System.out.println("=== RSA密钥生成结果 ===");
            System.out.println("\n公钥(Base64编码):");
            System.out.println(publicKeyBase64);
            System.out.println("\n私钥(Base64编码):");
            System.out.println(privateKeyBase64);
            System.out.println("\n密钥算法: " + publicKey.getAlgorithm());
            System.out.println("密钥长度: 2048位");

        } catch (NoSuchAlgorithmException e) {
            System.err.println("生成RSA密钥时出错: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 生成RSA密钥对
     * @param keySize 密钥长度（推荐2048位）
     * @return 密钥对对象
     * @throws NoSuchAlgorithmException
     */
    public static KeyPair generateRSAKeyPair(int keySize) throws NoSuchAlgorithmException {
        // 获取RSA密钥对生成器实例
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

        // 初始化密钥长度
        keyPairGenerator.initialize(keySize);

        // 生成并返回密钥对
        return keyPairGenerator.generateKeyPair();
    }
}
