package util;

public class KeyPair {
    private String publicKey;
    private String privateKey;

    public KeyPair() {
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return this.privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String toString() {
        return "KeyPair [publicKey=" + this.publicKey + ", privateKey=" + this.privateKey + "]";
    }
}
