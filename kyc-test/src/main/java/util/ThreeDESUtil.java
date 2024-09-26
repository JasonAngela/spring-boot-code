package util;


import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;
import java.util.Random;

public class ThreeDESUtil {
   // private static Logger log = LoggerFactory.getLogger(ThreeDESUtil.class);
    public static final String KEY_ALGORITHM = "DESede";
    public static final String CIPHER_ALGORITHM_ECB = "DESede/ECB/PKCS5Padding";

    public ThreeDESUtil() {
    }


    public static String encode(String key, String data) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(build3DesKey(key));
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(1, deskey);
        byte[] bOut = cipher.doFinal(data.getBytes("UTF-8"));
        return byte2HexStr(bOut);
    }

    public static String decode(String key, String data) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(build3DesKey(key));
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(2, deskey);
        byte[] bOut = cipher.doFinal(str2ByteArray(data));
        return new String(bOut, "UTF-8");
    }

    public static String decodeInitKey(String data) throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(build3DesKey("vH*2CWQm%W#un01q"));
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(2, deskey);
        byte[] bOut = cipher.doFinal(str2ByteArray(data));
        return new String(bOut, "UTF-8");
    }

    public static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        } else {
            int l = strhex.length();
            if (l % 2 == 1) {
                return null;
            } else {
                byte[] b = new byte[l / 2];

                for(int i = 0; i != l / 2; ++i) {
                    b[i] = (byte)Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
                }

                return b;
            }
        }
    }

    public static String byteToHex(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src != null && src.length > 0) {
            for(int i = 0; i < src.length; ++i) {
                int v = src[i] & 255;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }

                stringBuilder.append(hv);
            }

            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    public static String encodeNew(String key, String data) {
        String result = null;

        try {
            result = encode(key, data);
        } catch (Exception var4) {
           // log.error("exception is {}", var4);
        }

        return result;
    }

    private static byte[] build3DesKey(String keyStr) throws Exception {
        byte[] key = new byte[24];
        byte[] temp = keyStr.getBytes("UTF-8");
        if (key.length > temp.length) {
            System.arraycopy(temp, 0, key, 0, temp.length);
        } else {
            System.arraycopy(temp, 0, key, 0, key.length);
        }

        return key;
    }

    private static String byte2HexStr(byte[] b) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < b.length; ++i) {
            String s = Integer.toHexString(b[i] & 255);
            if (s.length() == 1) {
                sb.append("0");
            }

            sb.append(s.toUpperCase());
        }

        return sb.toString();
    }

    private static byte[] str2ByteArray(String s) {
        int byteArrayLength = s.length() / 2;
        byte[] b = new byte[byteArrayLength];

        for(int i = 0; i < byteArrayLength; ++i) {
            byte b0 = (byte)Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16);
            b[i] = b0;
        }

        return b;
    }

   /* public static String getKey() throws Exception {
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(build3DesKey("vH*2CWQm%W#un01q"));
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
        deskey = keyfactory.generateSecret(spec);
        //return Base64.encode(deskey.getEncoded());
    }*/

    public static String createKey() throws Exception {
        return randomHexString(24);
    }

    private static String randomHexString(int len) {
        try {
            StringBuffer result = new StringBuffer();

            for(int i = 0; i < len; ++i) {
                result.append(Integer.toHexString((new Random()).nextInt(16)));
            }

            return result.toString().toUpperCase();
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println(encode("vH*2CWQm%W#un01q", "20CE7B390A4FA9C14E903618A44EFE483B3E0E8709953E414FAA2A825DABD904DBFFA651EF841D9B8D738E69CEA74EFDDA6AEA27B2990CEFBAA054A0EAC30F99"));
        /*String data = "{\"data\":{\"resultScore\":\"740\",\"idRegionMatch\":\"000\",\"idFake\":\"0\",\"ipCnt\":\"0\",\"ggCnt\":\"0\",\"shCnt\":\"0\",\"gtCnt\":\"-99\",\"investAmt\":\"0.0\",\"maxfRegAmt\":\"0.0\",\"maxgRegAmt\":\"0.0\",\"earliestCons\":\"35\",\"consvariety\":\"-999\",\"consTypeAmtrate\":\"0.4083\",\"consTypeCntrate\":\"0.3\",\"consume12Amt\":\"16.8\",\"consume12Cnt\":\"1\",\"type12Sum\":\"0\",\"level12Consume\":\"1\",\"totalFlightTimes\":\"\",\"avgFlightPrice\":\"\",\"avgFlightDiscount\":\"\",\"monthNum\":\"1\",\"monMaxRecord\":\"16.8\",\"latestRecord\":\"11\",\"maxIntervalMonth\":\"6\",\"cosStab\":\"0\",\"label24Num\":\"4\",\"close12MeanMoney\":\"0\",\"child6Money\":\"0\",\"child6Num\":\"0\",\"car6Money\":\"0\",\"car6Num\":\"0\",\"diamond6Money\":\"0\",\"diamond6Num\":\"0\",\"sports6Money\":\"0\",\"sports6Num\":\"0\",\"ent6Money\":\"0\",\"ent6Num\":\"0\",\"digital6Money\":\"0\",\"digital6Num\":\"0\",\"virtual6Money\":\"0\",\"virtual6Num\":\"0\",\"hose6Money\":\"0\",\"hose6Num\":\"0\",\"wdyq\":\"0\",\"creditYq\":\"0\",\"creditQz\":\"0\",\"totalSxCnt\":\"0\",\"sxCnt1Year\":\"0\",\"sxCnt5Year\":\"0\",\"totalZxCnt\":\"0\",\"zxCnt1Year\":\"0\",\"zxCnt5Year\":\"0\",\"lpSx\":\"0\",\"ggSx\":\"0\",\"shSx\":\"0\",\"gtSx\":\"-99\",\"lpZx\":\"0\",\"ggZx\":\"0\",\"shZx\":\"0\",\"gtZx\":\"-99\",\"bankQueryCnt3\":\"-99\",\"nonBankQueryCnt3\":\"-99\",\"bankQueryCnt12\":\"-99\",\"nonBankQueryCnt12\":\"-99\",\"bankInstCnt3\":\"-99\",\"nonBankInstCnt3\":\"-99\",\"bankInstCnt12\":\"-99\",\"nonBankInstCnt12\":\"-99\",\"p2pQueryCnt3\":\"-99\",\"consFinQueryCnt3\":\"-99\",\"microFinQueryCnt3\":\"-99\",\"p2pQueryCnt12\":\"-99\",\"consFinQueryCnt12\":\"-99\",\"microFinQueryCnt12\":\"-99\",\"isNetHighRisk\":\"0\",\"isFm\":\"0\",\"isFx\":\"0\"},\"isExitEdb\":true,\"isExitHangju\":false,\"isExitEdu\":true,\"isExitRisk\":false,\"isExitEnt\":false,\"isExitUmpScore\":false,\"identity\":77,\"credithistory\":88,\"performance\":67,\"consumption\":100,\"social\":70,\"riskScore\":0,\"cid\":\"21091119880517052X\",\"name\":\"马莹\",\"mobile\":\"13426198891\",\"desKey\":\"94ca8dd140a962e1c9767a9edc2881e5df218e6d1530962f9333ef6c2a909785\",\"rsaKey\":\"308204bc020100300d06092a864886f70d0101010500048204a6308204a20201000282010100bab4e543fe96c5d19f5f1683b35f34e75c7bdf5a5dcc5df6eecb61d1a173fad2bb7e77c66fd4520fae1ebd12a88737e36a582ece085d464de8d47ebfb1fdc148abfe16e15aad889b786cf6fee0be3312a180a751776cba29a4945e2aaded679da9427a6b7d231804ea5984c3cfc7da41fbf010de275b70e66b7e494ae807b7420a8dd4560b9fab34c4af60372c265bb323e1cab049c37f630c5c768c669c718bbb941ef6931be26016e840e1ff34850266f2559a2a92f4765aa84ce451e931d26349174c5cd394d8a849477c3ea14b33ad164bfab6c7b0969681c2d86cc1adbde36f42ffc9890f670da17be26e3ff424da3c9793eed019d0803422fabb6d978902030100010282010036de8ab21cd3ba770c5b2986b2e43bebf2660511cd970dd64fff3d541a1ab78fcec22ff9054c64816f2e616a6654b6bc02b8bfa89514b460991839d7a43b6ade2c8d93b3ceae490347b4de31b162b427b986d1a5436f94964063c9f8c8fc8802f18733eafaefa153707bb664c55f7a6901dd5f57aa4159409e3e92d38cb517c9b3c2322f40ea55c2c96d68c27464cddee50200a44b843a0b61b8ff70575689f527dd67ea352e49c6e2b66b86a3f7c31d46917dd87b899375c3a90caa8563134bb7c4635656a67540cfbe8b62088ef4817bc2cde00d296fac497e6781d4102c3b33803496feeae593a5a9916f676b003b51adcc0fc08fd0b0cf8529cab2f2a8c102818100ef429e127fb075d4ee291717f12a7e3bcc29d17352ce4646932f245a6639c5b1ad804dcfd4dad4e9a794ba0c03d22665ce14454b0d142a86b559954fc267805886fa92faae92e9f130ae6da02af3ca42078b0046e4d1c045872e0129f8569da2dee7d8e9db06e497065907a6f92907edcf867951da82193afd3afa3cff8cdc7502818100c7c4fdfe6358c350db0a89598a1b41be55f3c3c64b1d57f411c30641393c6d472ed8f6bee4a25cc5c0f945b124d29e21f8a34ef787cd621bffb51cde985d43c146cc969284aa4fe4439011d6484cd4e39b62a77bf449740ac1e1463962e64cefe7150cf2876463153585b6f1b401ed242460561dc201f4e101975e043947fc450281803e7600b84997729b7cf5432f1fe97cfcf566b1644ee8c4d5e5d4b7c3d5ce1d3b2e55417b115173a5eff6d6bf0e3c4d83e451cc693467e0563c7fbf880bf363413933af2d3c67e424f015894ef8079ef4afed6ccc152e60e885cacfc8fa28fa8c2b6f1164b3a65004d1466ac5ff63e3cb04935196b9d99ee69477521e9c84548502818005c6bd6d68a3fd69ce1b9ce318ea36d97114ce59627ca3b96bf60ead3e21702b79c04e4a30c43d187ebef673ebd3a73ce63a9aa2efab51a5eb9bea0cc9ad10b37aff996efd250b90571fc85440dcefdef0f44651803bcb7e3022fa6bd85f3e644573475f8fe8a830c9ce66fed02caa15bc7388a9ed9d2ede7eb448c4a87f5b5d02818043936e10c09bb51c3dbaa0390734023d166fc7fa3043f293df31d83b2410a41206f2bbc1f3029f2bc9822c4df0164aee4f0713800fdf931825fa7a0f05c8588af74f7888b31b7977b02e8b699917efb36b95d2c7d39825f7c6c811a71bd707f03e883455f61667985df464679f5bd498e1aafd4d3bef537618b4cce39cd0a632\",\"isLinDong\":\"1\",\"chargeStatus\":56}";
        System.out.println("加密前：" + data);

        try {
            String key = "94ca8dd140a962e1c9767a9edc2121e5df218e6d1531112f9333ef6c2a909755";
            System.out.println("key :" + key);
            String encode = encode(key, data);
            System.out.println("加密后：" + encode);
            String decode = decode(key, encode);
            System.out.println("解密后：" + decode);
            System.out.println("F2104E0281235976849D13C3557ABAEA".length());
            System.out.println(encode("vH*2CWQm%W#un01q", "20CE7B390A4FA9C14E903618A44EFE483B3E0E8709953E414FAA2A825DABD904DBFFA651EF841D9B8D738E69CEA74EFDDA6AEA27B2990CEFBAA054A0EAC30F99"));
        } catch (Exception var5) {
            log.error("exception is {}", var5);
        }*/

    }
}
