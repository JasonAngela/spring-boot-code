package util;

/**
 * <p></p>
 *
 * @author yml
 * @since 2024/2/5
 */
public class GetKeys {

    public GetKeys() {
    }

    public static void main(String[] args) throws Exception {
        //String pro = ThreeDESUtil.decode("vH*2CWQm%W#un01q", "83552628BA8AC5CACCCDD1AE20F6D44D4A05654AC44EDEEF6D3A9AEACBBCBF5397113B535C305178");
        /*String str = getSm4();
        System.out.println(str);*/
        KeyPair key = getSm2();
        System.out.println(key.getPublicKey());
        System.out.println(ThreeDESUtil.encode("vH*2CWQm%W#un01q", key.getPublicKey()));
        System.out.println(key.getPrivateKey());
        System.out.println(ThreeDESUtil.encode("vH*2CWQm%W#un01q", key.getPrivateKey()));
    }

    public static KeyPair getSm2() {
        return SM2Utils.generateKeyPair();
    }

    /*public static String getSm4() throws Exception {
        return SM4.generateKeyECB();
    }*/
}
