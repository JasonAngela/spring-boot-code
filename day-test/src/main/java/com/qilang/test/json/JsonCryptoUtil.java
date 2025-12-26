package com.qilang.test.json;

import com.alibaba.fastjson.JSONObject;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class JsonCryptoUtil {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public static String encryptToUrlSafe(JSONObject json, String secretKey) throws Exception {
        if(secretKey.length() != 16) {
            throw new IllegalArgumentException("密钥必须是16字节长度");
        }
        String data = json.toJSONString();
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return java.util.Base64.getUrlEncoder().withoutPadding().encodeToString(encrypted);
    }

    public static JSONObject decryptFromUrlSafe(String encryptedStr, String secretKey) throws Exception {
        if(secretKey.length() != 16) {
            throw new IllegalArgumentException("密钥必须是16字节长度");
        }
        SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decoded = java.util.Base64.getUrlDecoder().decode(encryptedStr);
        String decrypted = new String(cipher.doFinal(decoded), StandardCharsets.UTF_8);
        return JSONObject.parseObject(decrypted);
    }

    public static void main(String[] args) throws Exception {
        String key = "16ByteSecretKey1"; // 必须是16字节

        JSONObject obj = new JSONObject();
        obj.put("backUrl", "www.baidu.com");
        obj.put("orgId", "MjRSMTNmdzROSlRQSFhGamRtTXZnQT09");

        obj.put("reportSpeed", "1");
        obj.put("chsName", "MjRSMTNmdzROSlRQSFhGamRtTXZnQT09");

        String encrypted = encryptToUrlSafe(obj, key);
        System.out.println("URL安全加密结果：" + encrypted);

        JSONObject decrypted = decryptFromUrlSafe(encrypted, key);
        System.out.println("解密结果：" + decrypted);
    }
}
