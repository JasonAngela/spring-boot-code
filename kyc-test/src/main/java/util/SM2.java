package util;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECFieldElement.Fp;
import org.bouncycastle.math.ec.ECPoint;

import java.math.BigInteger;
import java.security.SecureRandom;

public class SM2 {
    public static String[] ecc_param = new String[]{"FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF", "FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC", "28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93", "FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123", "32C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7", "BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0"};
    public final BigInteger ecc_p;
    public static BigInteger ecc_a;
    public static BigInteger ecc_b;
    public final BigInteger ecc_n;
    public static BigInteger ecc_gx;
    public static BigInteger ecc_gy;
    public final ECCurve ecc_curve;
    public final ECPoint ecc_point_g;
    public final ECDomainParameters ecc_bc_spec;
    public final ECKeyPairGenerator ecc_key_pair_generator;
    public final ECFieldElement ecc_gx_fieldelement;
    public final ECFieldElement ecc_gy_fieldelement;

    public SM2() {
        this.ecc_p = new BigInteger(ecc_param[0], 16);
        ecc_a = new BigInteger(ecc_param[1], 16);
        ecc_b = new BigInteger(ecc_param[2], 16);
        this.ecc_n = new BigInteger(ecc_param[3], 16);
        ecc_gx = new BigInteger(ecc_param[4], 16);
        ecc_gy = new BigInteger(ecc_param[5], 16);
        this.ecc_gx_fieldelement = new Fp(this.ecc_p, ecc_gx);
        this.ecc_gy_fieldelement = new Fp(this.ecc_p, ecc_gy);
        this.ecc_curve = new ECCurve.Fp(this.ecc_p, ecc_a, ecc_b);
        this.ecc_point_g = new ECPoint.Fp(this.ecc_curve, this.ecc_gx_fieldelement, this.ecc_gy_fieldelement);
        this.ecc_bc_spec = new ECDomainParameters(this.ecc_curve, this.ecc_point_g, this.ecc_n);
        ECKeyGenerationParameters ecc_ecgenparam = new ECKeyGenerationParameters(this.ecc_bc_spec, new SecureRandom());
        this.ecc_key_pair_generator = new ECKeyPairGenerator();
        this.ecc_key_pair_generator.init(ecc_ecgenparam);
    }

    public void sm2Sign(byte[] md, BigInteger userD, ECPoint userKey, SM2Result sm2Result) {
        BigInteger e = new BigInteger(1, md);
        BigInteger k = null;
        ECPoint kp = null;
        BigInteger r = null;
        BigInteger s = null;

        while(true) {
            do {
                String kS = "6CB28D99385C175C94F94E934817663FC176D925DD72B727260DBAAE2FB2F96F";
                k = new BigInteger(kS, 16);
                kp = this.ecc_point_g.multiply(k);
                r = e.add(kp.getXCoord().toBigInteger());
                r = r.mod(this.ecc_n);
            } while(r.equals(BigInteger.ZERO));

            if (!r.add(k).equals(this.ecc_n)) {
                BigInteger da_1 = userD.add(BigInteger.ONE);
                da_1 = da_1.modInverse(this.ecc_n);
                s = r.multiply(userD);
                s = k.subtract(s).mod(this.ecc_n);
                s = da_1.multiply(s).mod(this.ecc_n);
                if (!s.equals(BigInteger.ZERO)) {
                    sm2Result.r = r;
                    sm2Result.s = s;
                    return;
                }
            }
        }
    }

    public static byte[] sm2GetZ(byte[] userId, ECPoint userKey) {
        SM3Digest sm3 = new SM3Digest();
        int len = userId.length * 8;
        sm3.update((byte)(len >> 8 & 255));
        sm3.update((byte)(len & 255));
        sm3.update(userId, 0, userId.length);
        byte[] p = ecc_a.toByteArray();
        sm3.update(p, 0, p.length);
        p = ecc_b.toByteArray();
        sm3.update(p, 0, p.length);
        p = ecc_gx.toByteArray();
        sm3.update(p, 0, p.length);
        p = ecc_gy.toByteArray();
        sm3.update(p, 0, p.length);
        p = userKey.getXCoord().toBigInteger().toByteArray();
        sm3.update(p, 0, p.length);
        p = userKey.getYCoord().toBigInteger().toByteArray();
        sm3.update(p, 0, p.length);
        byte[] md = new byte[sm3.getDigestSize()];
        sm3.doFinal(md, 0);
        return md;
    }
}
