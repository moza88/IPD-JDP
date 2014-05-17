package edu.depaul.ipd.jdp.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Signature;
import javax.crypto.Cipher;

/**
 * Example showing signature
 */
public class SignatureMain {

    public static void main(String[] args) throws Exception {
        //api();
        manual();
    }
    
    private static void api() throws Exception {
        byte[] plainText = "Hello World".getBytes("UTF8");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.digest(plainText);
        byte[] md = messageDigest.digest();
        
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair key = keyGen.genKeyPair();
        
        Signature sig = Signature.getInstance("MD5WithRSA");
        sig.initSign(key.getPrivate());
        sig.update(plainText);
        byte[] signature = sig.sign();
        System.out.println(new String(signature, "UTF8"));
        
        // verify the signature with the public key
        sig.initVerify(key.getPublic());
        sig.update(plainText);
        if (sig.verify(signature))
            System.out.println("Signature verified");
        
    }
    
    
    private static void manual() throws Exception {
        byte[] plainText = "Hello World".getBytes("UTF8");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.digest(plainText);
        byte[] md = messageDigest.digest();
        
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair key = keyGen.genKeyPair();
        Cipher ciper = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        ciper.init(Cipher.ENCRYPT_MODE, key.getPrivate());
        byte[] cipherText = ciper.doFinal(plainText);
        byte[] cipherDigest = ciper.doFinal(md);
        
        String ciphervalue = new String(cipherText, "UTF8");
        System.out.println("--- ciphered ----");
        System.out.println(ciphervalue);
        System.out.println("--- ciphered ----");
        
        // What happens when you change it so that you use public key to decipher
        // the message?
        ciper.init(Cipher.DECRYPT_MODE, key.getPublic());
        byte[] decrypt = ciper.doFinal(cipherText);
        byte[] decryptDigest = ciper.doFinal(cipherDigest);
                
        String decipherValue = new String(decrypt, "UTF8");
        
        System.out.println("--- deciphered ----");
        System.out.println(decipherValue);
        System.out.println("--- deciphered ----");
        
        if (decryptDigest.length != md.length) {
            System.out.println("MD length doesn't match");
            System.exit(-1);
        }
        
        for (int i = 0; i < decryptDigest.length; ++i) {
            if (md[i] != decryptDigest[i]) {
                System.out.println("MD content doesn't match");
                System.exit(-2);
            }
        }
        
    }
}

