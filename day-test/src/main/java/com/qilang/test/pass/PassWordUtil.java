/*
package com.qilang.test.pass;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.AsymmetricAlgorithm;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.digest.DigestUtil;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

public class PassWordUtil {

    */
/**
     * 密码加盐加密
     * @param originPassword 原密码
     * @return
     * @description 生成32位uuid作为盐，和原始密码拼接后进行md5加密，返回32位盐+加密后的密码
     *//*

    public static String encrypt(String originPassword) {
        // 32位盐
        String salt = IdUtil.simpleUUID();
        // 拼接
        originPassword = salt + originPassword;
        // md5加密
        String encryptedPassword = DigestUtil.md5Hex(originPassword);
        // 返回32位盐+加密后的密码
        return salt + encryptedPassword;
    }

    */
/**
     * 校验密码是否正确
     * @param originPassword 原密码
     * @param encryptedPassword 加密后的密码
     * @return
     *//*

    public static boolean check(String originPassword, String encryptedPassword) {
        // 取出盐
        String salt = StrUtil.sub(encryptedPassword,0,32);
        // 真密码
        encryptedPassword = StrUtil.sub(encryptedPassword,32, encryptedPassword.length());
        // 拼接并加密
        originPassword = DigestUtil.md5Hex(salt + originPassword);
        // 判断md5加密后的拼接密码是否与真密码相同
        return originPassword.equals(encryptedPassword);
    }

    public static void main(String[] args) {
        // 1. 生成密钥对
     */
/*   RSA rsa = new RSA();
        String privateKey = rsa.getPrivateKeyBase64();
        String publicKey = rsa.getPublicKeyBase64();

        System.out.println("私钥:" + privateKey);
        System.out.println("公钥:" + publicKey);*//*

        // 2. 公钥加密
        */
/*String password = "123456";
        RSA rsaPublic = new RSA(null, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC0HrSW8Iz1aacTIn0S5u3EfjLxNAddyCEsDB/wCf4tv10rKT9ZaWX98oFPRPnNfk1knRosmLN7tZqdW7bp5ouIf2G2mVXaEoQ4qKZ+LifQpRxPZyMBMD8RzKW4VDOJQtw+zxS520dh5K9lkX8vRLrG/hWvECTJXETiKKufxThO8wIDAQAB");
        String encrypted = rsaPublic.encryptBase64(password, KeyType.PublicKey);*//*

       // System.out.println("加密后: " + encrypted);

        // 3. 私钥解密
        */
/*RSA rsaPrivate = new RSA("MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBALQetJbwjPVppxMifRLm7cR+MvE0B13IISwMH/AJ/i2/XSspP1lpZf3ygU9E+c1+TWSdGiyYs3u1mp1btunmi4h/YbaZVdoShDiopn4uJ9ClHE9nIwEwPxHMpbhUM4lC3D7PFLnbR2Hkr2WRfy9Eusb+Fa8QJMlcROIoq5/FOE7zAgMBAAECgYBTbfWQBJQGCI4O2ua8HqL7ZMkL2GGhGtXipSsV8Er/vafWGiDxtVQ8sFsc8IIUoPAQLoS1K3XXU2LuiFDNPrBaHPXna7GzjlDuUsID9bSXK09dC9iriV31fzKhOZg1a8ebVHX/G4neP7AgJWaCnvH4/F95asqujIEitBP6nI+2wQJBAPGiym8A9kTUCw07qHWlGNbllNF5jgM0h2a8QRvpe51QeBOHB1z6yjcPtwo4TKlGXv0XWlyCVy0BHt518I1tresCQQC+08QtoMMDyrh9FqXjwHErXPIDwIdMIWMwyAhfCVPyR61DfIfgJobMb4vN5DdDz7A9gbS4dSGab+0TKyMWGzkZAkEA14oJnsix5CVtEknD8+Tn6lDx1YTjK3LA0OBeB6LWdDYiVfDdnY/Lrx/ie0hLAbfW5VXecaSGVIuqWG/FurI6LwJBAJgfz5OkRfK+5+XoaSSv5EfyV4iAMhuRvjZEMNA6am6Jj2luXA9oByvwfJ4NIbVwWwodXYly7u/j7DXMvLLBzvkCQQDHU/DB8CxZlHradMHkvhqX6rVTEhH7sKdSNsOIEVb0OqaNK4aBzpQoLeKNoakG8bkVtI9egnC7LuUznjg1Adz3", null);
        String decrypted = rsaPrivate.decryptStr(encrypted, KeyType.PrivateKey);*//*

        //System.out.println("解密后: " + decrypted);

        //RSA rsa = new RSA(privateKey, publicKey);
        // 私钥加密,公钥解密
    */
/*    System.out.println(new String(rsa.encrypt("testaa", KeyType.PrivateKey)));
        System.out.println(new String(rsa.decrypt(rsa.encrypt("testaa", KeyType.PrivateKey), KeyType.PublicKey)));*//*


        // 公钥加密,私钥解密
        //System.out.println(new String(rsa.encrypt("testaa", KeyType.PublicKey)));

        //System.out.println(new String(rsa.decrypt(rsa.encrypt("testaa", KeyType.PublicKey), KeyType.PrivateKey)));
        */
/*String auth = "SJCJ001;null;";
        String[] atr = auth.split(";");
        System.out.println(atr.length);
        for (String s : atr) {
            System.out.println(s);
        }*//*



    }
}
*/
