package org.iton.messenger.server.secure;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import static org.iton.messenger.proto.secure.CryptoUtils.SHA1;
import static org.iton.messenger.proto.secure.CryptoUtils.ToHex;
import static org.iton.messenger.proto.secure.CryptoUtils.substring;

public class RSAServer
{
    private static final InternalLogger log = InternalLoggerFactory.getInstance(RSAServer.class);

    public static void resetKeyPair()
    {
        log.info("-------GENERATE PUBLIC and PRIVATE KEY-------------");
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048); //2048 used for normal securities

            KeyPair keyPair       = keyPairGenerator.generateKeyPair();
            PublicKey publicKey   = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");

            RSAPublicKeySpec publicKeySpec   = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
            RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

            log.info("Public Modulus     : " + ToHex(publicKeySpec.getModulus().toByteArray()));
            log.info("Public Exponent    : " + ToHex(publicKeySpec.getPublicExponent().toByteArray()));
            log.info("Public Fingerprint : " + ToHex(substring(SHA1(publicKeySpec.getModulus().toByteArray()),12, 8)));
            log.info("Private Modulus    : " + ToHex(privateKeySpec.getModulus().toByteArray()));
            log.info("Private Exponent   : " + ToHex(privateKeySpec.getPrivateExponent().toByteArray()));
            log.info("Private Fingerprint: " + ToHex(substring(SHA1(privateKeySpec.getModulus().toByteArray()), 12, 8)));


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
    public static class Key
    {
        private BigInteger modulus;
        private BigInteger publicExp;
        private BigInteger privateExp;
        private BigInteger fingerprint;

        public Key(String modulus, String publicExp, String privateExp, String fingerprint)
        {
            this.modulus     = new BigInteger(modulus, 0x10);
            this.publicExp   = new BigInteger(publicExp, 0x10);
            this.privateExp  = new BigInteger(privateExp, 0x10);
            this.fingerprint = new BigInteger(fingerprint, 0x10);
        }

        public BigInteger getModulus() {
            return modulus;
        }

        public BigInteger getPublicExponent() {
            return publicExp;
        }
        
        public BigInteger getPrivateExponent() {
            return privateExp;
        }
        

        public BigInteger getFingerprint() {
            return fingerprint;
        }
    }

    public static final Key RSA_KEY = new Key(
            "0080f64abf227f1fa0c8e79fdff164376ff9ef0502a753d76aceb60c1a732d5a41cabbf0040332c209f8f19ab62ec50e863fc69b4dd7645115290dc929ba05dbe5025d0fd54f2eb02e344c07ea8e77167f7ced9c4205f2ea95810fe9d2f0057c9d3b97443ec7830261584ae5fd7fccbb77b2df831fae80cfec760b1118bcdb385d34f7b1e769d3f182d5b81e875fdb8e0f4f7ef9c2f733b5d598a8ef593f2cb6b468900f8ce34df038a91b8c05760c28194ddea529c896ca10750f9127f3dcd64859e30d7a0c66fdf410c85ed072ca52cd570ceb4b360e473126593e4d9cf1ad6afb9021350e13f4fd6c2a99b0eccb2dc1023ecc4b1508d3150a933de35af152cd", 
            "010001",
            "665f1cc6cd638c7fddfbc075ccf178f072bec28370c0a5682bdf678c3791f0ebf93b67344835aac2afd35ab4f43b8964188c580c5ac74f7634b8b4cf62d3f3d2bf2590c40baf4c3be157d990e0b6b82d4bc6731c160cd71b06f0d2f49784437fad264f0e66e220a995a51f1d34ae18c2d443899b44b30c5af0f9a800b32a727aaa2f89ca8edd321ac0d8c0d58200578cd80536ec74ef01308befced114be8022c279c4bbebb7540e7684731d31e3107e297700274880d18195a3d48d3e868a478b11ae943db67c77e3aa2b4df92050206446344e85bafd17ee864ba3f77a467adfaba18a219a499ba180631bc227182f3840c2a3647acc5e564d322179ae9121", 
            "e14ed23f05b67a40");
}
