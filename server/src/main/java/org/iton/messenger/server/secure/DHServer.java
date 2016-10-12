package org.iton.messenger.server.secure;

import java.math.BigInteger;

import static org.iton.messenger.proto.secure.CryptoUtils.*;

/**
  JDK-6521844 : SecureRandom hangs on Linux Systems
  set securerandom.source to file:/dev/./urandom

  Another dhPrime from Telegram

 "C71CAEB9C6B1C9048E6C522F70F13F73" +
 "980D40238E3E21C14934D037563D930F" +
 "48198A0AA7C14058229493D22530F4DB" +
 "FA336F6E0AC925139543AED44CCE7C37" +
 "20FD51F69458705AC68CD4FE6B6B13AB" +
 "DC9746512969328454F18FAF8C595F64" +
 "2477FE96BB2A941D5BCD1D4AC8CC4988" +
 "0708FA9B378E3C4F3A9060BEE67CF9A4" +
 "A4A695811051907E162753B56B0F6B41" +
 "0DBA74D8A84B2A14B3144E0EF1284754" +
 "FD17ED950D5965B4B9DD46582DB1178D" +
 "169C6BC465B0D6FF9CA3928FEF5B9AE4" +
 "E418FC15E83EBEA0F87FA9FF5EED7005" +
 "0DED2849F47BF959D956850CE929851F" +
 "0D8115F635B105EE2E4E15D04B2454BF" +
 "6F4FADF034B10403119CD8E3B92FCC5B";

 */
public class DHServer
{
    public static byte[] getG_a(byte[] a)
    {
        BigInteger dh_power = loadBigInt(a);
        BigInteger dh_g     = BigInteger.valueOf(DH_KEY.getG());
        BigInteger dh_prime = loadBigInt(DH_KEY.getDhPrime());
        BigInteger g_a      = dh_g.modPow(dh_power, dh_prime);

        return g_a.toByteArray();
    }

    public static byte[] getAuthKey(byte[] g_b, byte[] seed)
    {
        BigInteger dh_power = loadBigInt(seed);
        BigInteger dh_prime = loadBigInt(DH_KEY.getDhPrime());
        BigInteger auth     = loadBigInt(g_b).modPow(dh_power, dh_prime);
        return alignKeyZero(fromBigInt(auth), 0x100);
    }

    public static class Key
    {
        private byte[] dhPrime;
        private int    g;

        private Key(String dhPrime, int g)
        {
            this.dhPrime = convert(dhPrime);
            this.g       = g;
        }

        public byte[] getDhPrime()
        {
            return dhPrime;
        }

        public int getG()
        {
            return g;
        }
    }

    public static final Key DH_KEY = new Key("FFFFFFFFFFFFFFFFC90FDAA22168C234" +
                                             "C4C6628B80DC1CD129024E088A67CC74" +
                                             "020BBEA63B139B22514A08798E3404DD" +
                                             "EF9519B3CD3A431B302B0A6DF25F1437" +
                                             "4FE1356D6D51C245E485B576625E7EC6" +
                                             "F44C42E9A637ED6B0BFF5CB6F406B7ED" +
                                             "EE386BFB5A899FA5AE9F24117C4B1FE6" +
                                             "49286651ECE45B3DC2007CB8A163BF05" +
                                             "98DA48361C55D39A69163FA8FD24CF5F" +
                                             "83655D23DCA3AD961C62F356208552BB" +
                                             "9ED529077096966D670C354E4ABC9804" +
                                             "F1746C08CA18217C32905E462E36CE3B" +
                                             "E39E772C180E86039B2783A2EC07A28F" +
                                             "B5C55DF06F4C52C9DE2BCBF695581718" +
                                             "3995497CEA956AE515D2261898FA0510" +
                                             "15728E5A8AACAA68FFFFFFFFFFFFFFFF", 2);

//    public static final Key DH_KEY = new Key("C71CAEB9C6B1C9048E6C522F70F13F73" +
//                                             "980D40238E3E21C14934D037563D930F" +
//                                             "48198A0AA7C14058229493D22530F4DB" +
//                                             "FA336F6E0AC925139543AED44CCE7C37" +
//                                             "20FD51F69458705AC68CD4FE6B6B13AB" +
//                                             "DC9746512969328454F18FAF8C595F64" +
//                                             "2477FE96BB2A941D5BCD1D4AC8CC4988" +
//                                             "0708FA9B378E3C4F3A9060BEE67CF9A4" +
//                                             "A4A695811051907E162753B56B0F6B41" +
//                                             "0DBA74D8A84B2A14B3144E0EF1284754" +
//                                             "FD17ED950D5965B4B9DD46582DB1178D" +
//                                             "169C6BC465B0D6FF9CA3928FEF5B9AE4" +
//                                             "E418FC15E83EBEA0F87FA9FF5EED7005" +
//                                             "0DED2849F47BF959D956850CE929851F" +
//                                             "0D8115F635B105EE2E4E15D04B2454BF" +
//                                             "6F4FADF034B10403119CD8E3B92FCC5B", 3);


}
