package util;

import java.util.LinkedHashMap;
import java.util.Map;

public class GetEncode {
    public GetEncode() {
    }

    public static Map<String, String> getAllEncode(String str) throws Exception {
        Map<String, String> response = new LinkedHashMap(16);
        response.put("SM2", getSm2(str, "BMTuSnkqxmzS8PtZV42VPB4FoFv05KMq4sd07EH7XNYYVVxWE3A53H1XtPQdP4+XzMCLUz8ogBWMby5BBlwZ/vw="));
        return response;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(getSm2("{\"entity\":\"91110108717743469K\",\"years\":\"2021,2022\"}", "20CE7B390A4FA9C14E903618A44EFE483B3E0E8709953E414FAA2A825DABD904DBFFA651EF841D9B8D738E69CEA74EFDDA6AEA27B2990CEFBAA054A0EAC30F99"));
    }

    public static String getSm2(String str, String key) throws Exception {
        return SM2Utils.encryptByPK1(key, str);
    }

    /*public static String getSm4(String str, String key, String encode) throws Exception {
        return SM4.encrypt_ECB(key, str, encode);
    }*/

    /*public static String getSm2NoCh(String str, String key) throws Exception {
        String data = SM2Utils.encryptByPK1NoCh(key, str);
        return data != null && !StringUtil.isMessyCode(data) ? data : null;
    }*/

    public static String get3Des(String str, String key) throws Exception {
        return ThreeDESUtil.encode(key, str);
    }

    /*public static String getRsa(String str, String key) throws Exception {
        return RSACoder.encryptByPublicKey(str, key);
    }

    public static String getAes(String str, String key) throws Exception {
        return AESUtil.aesEncodeECB(key, str);
    }*/

    /*public static String getMd5(String str) {
        return MD5Util.MD5(str).toUpperCase();
    }*/
}
