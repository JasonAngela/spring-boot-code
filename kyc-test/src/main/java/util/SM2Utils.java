package util;

import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;


import java.io.IOException;
import java.math.BigInteger;

public class SM2Utils {
    private static SM2 sm2 = new SM2();

    public static void main(String[] args) {

        KeyPair pair = generateKeyPair();
        System.out.println(pair.getPublicKey());
        System.out.println(pair.getPrivateKey());

    }
    public SM2Utils() {
    }

    public static KeyPair generateKeyPair() {
        KeyPair keyPair = new KeyPair();
        AsymmetricCipherKeyPair key = sm2.ecc_key_pair_generator.generateKeyPair();
        ECPrivateKeyParameters ecpriv = (ECPrivateKeyParameters)key.getPrivate();
        ECPublicKeyParameters ecpub = (ECPublicKeyParameters)key.getPublic();
        BigInteger privateKey = ecpriv.getD();
        ECPoint publicKey = ecpub.getQ();
        String pk = Util.byteToHex(publicKey.getEncoded(true)).substring(2, Util.byteToHex(publicKey.getEncoded(true)).length());
        String vk = Util.byteToHex(privateKey.toByteArray());
        if (vk.length() != 64 && vk.length() == 66 && vk.substring(0, 2).equals("00")) {
            vk = vk.substring(2, vk.length());
        } else if (vk.length() != 64) {
        }

        keyPair.setPrivateKey(vk);
        keyPair.setPublicKey(pk);
        return keyPair;
    }

    public static String encryptByPK1(String publicKey, String data) throws IOException {
        if (publicKey != null && publicKey.length() != 0) {
            if (data != null && data.length() != 0) {
                publicKey = "04" + publicKey;
                byte[] publicKeyBytes = ByteUtils.fromHexString(publicKey);
                data = ByteUtils.toHexString(data.getBytes("UTF-8"));
                byte[] plainTextBytes = ByteUtils.fromHexString(data);
                byte[] source = new byte[plainTextBytes.length];
                System.arraycopy(plainTextBytes, 0, source, 0, plainTextBytes.length);
                Cipher cipher = new Cipher();
                ECPoint userKey = sm2.ecc_curve.decodePoint(publicKeyBytes);
                ECPoint c1 = cipher.Init_enc(sm2, userKey);
                cipher.Encrypt(source);
                byte[] c3 = new byte[32];
                cipher.Dofinal(c3);
                String C1 = Util.byteToHex(c1.getEncoded(true));
                String C2 = Util.byteToHex(source);
                String C3 = Util.byteToHex(c3);
                String encData = C1 + C2 + C3;
                return encData.substring(2, encData.length());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static String decryptByVK1(String privateKey, String encryptedData) throws IOException {
        if (privateKey != null && privateKey.length() != 0) {
            if (encryptedData != null && encryptedData.length() != 0) {
                String data = "04" + encryptedData;
                byte[] c1Bytes = Util.hexToByte(data.substring(0, 130));
                int c2Len = Util.hexToByte(data).length - 97;
                byte[] c2 = Util.hexToByte(data.substring(130, 130 + 2 * c2Len));
                byte[] c3 = Util.hexToByte(data.substring(130 + 2 * c2Len, 194 + 2 * c2Len));
                BigInteger userD = new BigInteger(1, Util.hexToByte(privateKey));
                ECPoint c1 = sm2.ecc_curve.decodePoint(c1Bytes);
                Cipher cipher = new Cipher();
                cipher.Init_dec(userD, c1);
                cipher.Decrypt(c2);
                cipher.Dofinal(c3);
                String plainData = Util.byteToHex(c2);
                return new String(ByteUtils.fromHexString(plainData), "UTF-8");
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static String decryptByVK2(String privateKey, String encryptedData) throws IOException {
        if (privateKey != null && privateKey.length() != 0) {
            if (encryptedData != null && encryptedData.length() != 0) {
                String C1 = encryptedData.substring(0, 128);
                String C3 = encryptedData.substring(128, 192);
                String C2 = encryptedData.substring(192, encryptedData.length());
                String data = "04" + C1 + C2 + C3;
                System.out.println("Data=" + data);
                byte[] c1Bytes = Util.hexToByte(data.substring(0, 130));
                int c2Len = Util.hexToByte(data).length - 97;
                byte[] c2 = Util.hexToByte(data.substring(130, 130 + 2 * c2Len));
                byte[] c3 = Util.hexToByte(data.substring(130 + 2 * c2Len, 194 + 2 * c2Len));
                BigInteger userD = new BigInteger(1, Util.hexToByte(privateKey));
                ECPoint c1 = sm2.ecc_curve.decodePoint(c1Bytes);
                Cipher cipher = new Cipher();
                cipher.Init_dec(userD, c1);
                cipher.Decrypt(c2);
                cipher.Dofinal(c3);
                String plainData = Util.byteToHex(c2);
                return plainData;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static String encryptByPK1NoCh(String publicKey, String data) throws IOException {
        if (publicKey != null && publicKey.length() != 0) {
            if (data != null && data.length() != 0) {
                publicKey = "04" + publicKey;
                byte[] publicKeyBytes = ByteUtils.fromHexString(publicKey);
                byte[] plainTextBytes = ByteUtils.fromHexString(data);
                byte[] source = new byte[plainTextBytes.length];
                System.arraycopy(plainTextBytes, 0, source, 0, plainTextBytes.length);
                Cipher cipher = new Cipher();
                ECPoint userKey = sm2.ecc_curve.decodePoint(publicKeyBytes);
                ECPoint c1 = cipher.Init_enc(sm2, userKey);
                cipher.Encrypt(source);
                byte[] c3 = new byte[32];
                cipher.Dofinal(c3);
                String C1 = Util.byteToHex(c1.getEncoded(true));
                String C2 = Util.byteToHex(source);
                String C3 = Util.byteToHex(c3);
                String encData = C1 + C2 + C3;
                return encData.substring(2, encData.length());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static String decryptByVK1NoCh(String privateKey, String encryptedData) throws IOException {
        if (privateKey != null && privateKey.length() != 0) {
            if (encryptedData != null && encryptedData.length() != 0) {
                String data = "04" + encryptedData;
                byte[] c1Bytes = Util.hexToByte(data.substring(0, 130));
                int c2Len = Util.hexToByte(data).length - 97;
                byte[] c2 = Util.hexToByte(data.substring(130, 130 + 2 * c2Len));
                byte[] c3 = Util.hexToByte(data.substring(130 + 2 * c2Len, 194 + 2 * c2Len));
                BigInteger userD = new BigInteger(1, Util.hexToByte(privateKey));
                ECPoint c1 = sm2.ecc_curve.decodePoint(c1Bytes);
                Cipher cipher = new Cipher();
                cipher.Init_dec(userD, c1);
                cipher.Decrypt(c2);
                cipher.Dofinal(c3);
                String plainData = Util.byteToHex(c2);
                return plainData;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
