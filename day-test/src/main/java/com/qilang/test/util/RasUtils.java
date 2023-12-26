package com.qilang.test.util;

import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RasUtils {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static final int MAX_DECRYPT_BLOCK = 128;

    public RasUtils() {
    }


    public static String decryptPrivateData(String data, String private_key) throws Exception {
        RSAPrivateKey priKey = (RSAPrivateKey)RasUtils.getPrivateKey(private_key);
        String mi = RasUtils.decryptByPrivateKey(data, priKey);
        return mi;
    }

    public static String encryptedPublicData(String data, String public_key) throws Exception {
        RSAPublicKey pubKey = (RSAPublicKey)RasUtils.getPublicKey(public_key);
        String mi = RasUtils.encryptByPublicKey(data, pubKey);
        return mi;
    }


    public static RSAPublicKey getPublicKey(String modulus, String public_exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(public_exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
            return (RSAPublicKey)keyFactory.generatePublic(keySpec);
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public static RSAPrivateKey getPrivateKey(String modulus, String private_exponent) {
        try {
            BigInteger b1 = new BigInteger(modulus);
            BigInteger b2 = new BigInteger(private_exponent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
            return (RSAPrivateKey)keyFactory.generatePrivate(keySpec);
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public static String encryptByPublicKey(String data, RSAPublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(1, publicKey);
        int key_len = publicKey.getModulus().bitLength() / 8;
        String[] datas = splitString(data, key_len - 11);
        String mi = "";
        String[] var6 = datas;
        int var7 = datas.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            String s = var6[var8];
            mi = mi + bcd2Str(cipher.doFinal(s.getBytes()));
        }

        return mi;
    }

    public static String encryptByPublicKey(String data, RSAPrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(1, privateKey);
        int key_len = privateKey.getModulus().bitLength() / 8;
        String[] datas = splitString(data, key_len - 11);
        String mi = "";
        String[] var6 = datas;
        int var7 = datas.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            String s = var6[var8];
            mi = mi + bcd2Str(cipher.doFinal(s.getBytes()));
        }

        return mi;
    }

    public static String decryptByPrivateKey(String data, RSAPrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, privateKey);
        int key_len = privateKey.getModulus().bitLength() / 8;
        byte[] bytes = data.getBytes();
        byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
        // System.err.println(bcd.length);
        String ming = "";
        byte[][] arrays = splitArray(bcd, key_len);
        byte[][] var8 = arrays;
        int var9 = arrays.length;

        for(int var10 = 0; var10 < var9; ++var10) {
            byte[] arr = var8[var10];
            ming = ming + new String(cipher.doFinal(arr));
        }

        return ming;
    }

    public static String decryptByPrivateKey(String data, RSAPublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, publicKey);
        int key_len = publicKey.getModulus().bitLength() / 8;
        byte[] bytes = data.getBytes();
        byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
        // System.err.println(bcd.length);
        String ming = "";
        byte[][] arrays = splitArray(bcd, key_len);
        byte[][] var8 = arrays;
        int var9 = arrays.length;

        for(int var10 = 0; var10 < var9; ++var10) {
            byte[] arr = var8[var10];
            ming = ming + new String(cipher.doFinal(arr));
        }

        return ming;
    }

    public static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {
        byte[] bcd = new byte[asc_len / 2];
        int j = 0;

        for(int i = 0; i < (asc_len + 1) / 2; ++i) {
            bcd[i] = asc_to_bcd(ascii[j++]);
            bcd[i] = (byte)((j >= asc_len ? 0 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
        }

        return bcd;
    }

    public static byte asc_to_bcd(byte asc) {
        byte bcd;
        if (asc >= 48 && asc <= 57) {
            bcd = (byte)(asc - 48);
        } else if (asc >= 65 && asc <= 70) {
            bcd = (byte)(asc - 65 + 10);
        } else if (asc >= 97 && asc <= 102) {
            bcd = (byte)(asc - 97 + 10);
        } else {
            bcd = (byte)(asc - 48);
        }

        return bcd;
    }

    public static String bcd2Str(byte[] bytes) {
        char[] temp = new char[bytes.length * 2];

        for(int i = 0; i < bytes.length; ++i) {
            char val = (char)((bytes[i] & 240) >> 4 & 15);
            temp[i * 2] = (char)(val > '\t' ? val + 65 - 10 : val + 48);
            val = (char)(bytes[i] & 15);
            temp[i * 2 + 1] = (char)(val > '\t' ? val + 65 - 10 : val + 48);
        }

        return new String(temp);
    }

    public static String[] splitString(String string, int len) {
        int x = string.length() / len;
        int y = string.length() % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }

        String[] strings = new String[x + z];
        String str = "";

        for(int i = 0; i < x + z; ++i) {
            if (i == x + z - 1 && y != 0) {
                str = string.substring(i * len, i * len + y);
            } else {
                str = string.substring(i * len, i * len + len);
            }

            strings[i] = str;
        }

        return strings;
    }

    public static byte[][] splitArray(byte[] data, int len) {
        int x = data.length / len;
        int y = data.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }

        byte[][] arrays = new byte[x + z][];

        for(int i = 0; i < x + z; ++i) {
            byte[] arr = new byte[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(data, i * len, arr, 0, y);
            } else {
                System.arraycopy(data, i * len, arr, 0, len);
            }

            arrays[i] = arr;
        }

        return arrays;
    }

    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    public static void main(String[] args) throws Exception {
        RSAPrivateKey priKey = (RSAPrivateKey)RasUtils.getPrivateKey("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIWfHO6b+pEzHWhimQfLebYI75sTbw2EgAxEoCTd/xKgT1K+kX35Up3AeJK0rgEj8G3EvXVrU5LIrZDGHM1P39PNUMXYN9UF4mOnoZAm3Cpj2G3hIvvG0LFB9HBAMquONutouNXdrNsUN5Z8uiEm8P0RL28qMsqN6xo7DPICzKGnAgMBAAECgYA/OS72U4U2aKoUdvqTbppTIF1G0eYszjHMHDht2UBUbte5fgPXSD3n+GbUe3sNfRTIy1sdkL/FZwCAzMxZ9N4hZDA+IxuC8P8yjy7IiQ1s6geIDcR7RePKh5HoEV710Qm0SAzhub/Cua+kKuoJt8LNGikbX8bZmyHgIW5HNKIH2QJBAOrH/YBRjCTD9p53cXdbP/ec9qV0qcPvSDcwnnex0HotHvNXkliGnk5jk5P88OkljlIkz21bSBM+GIbYw5+5Va0CQQCRsqT3Ba464a8zq433DkcdGRjC1H6F0rhTlaYEg3ilXeNlEL1ksTvxifWQOnJL8Mpmp5OJaDyUH8IdweanfPcjAkEAvhGp6HgcPKdowGFyOm5lGtC33LrVtQnCLOvvXndVj5N3uwjqMUDKaCu1Ddl4L0d4MIgcZSvA7dMXiBN0S5p/AQJAHzKCckZsHT2P919noZwUDB4AmE9J3DvXrkYf611/auFkvJJOC46LyFeDFmP9b1da74o4ZDbGqez28so/KmPuwwJABorXnOcklNlxngJzEI02m7aG8iBoLAyjOTaUbNHzQiyyuH/S+DmkQlF4LcrMNBZdZvHIv+hVvSxv3Zq9z3G3rg==");
        String pwd = RasUtils.decryptByPrivateKey("$2a$10$9AOXvNwkTIp7UiwJOHPEae8EuZWYe8ABg14MemEkf9edE3tLFIz06", priKey);
        System.out.println(pwd);
    }

}
