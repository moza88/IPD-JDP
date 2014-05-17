package edu.depaul.ipd.jdp.security;


import edu.depaul.ipd.jdp.security.encryption.Asymetric;
import edu.depaul.ipd.jdp.security.encryption.Symetric;

/**
 * Example showing use of different keys
 */
public class KeyMain {
    public static void main(String[] args) throws Exception {
//        symetric();
        asymmetric();
    }
    
    
    private static void symetric() throws Exception {
        byte[] plainText = "Hello World".getBytes("UTF8");
        
        Symetric symetric = new Symetric();
        byte[] cipherText = symetric.encrypt(plainText);
        
        String ciphervalue = new String(cipherText, "UTF8");
        System.out.println("--- ciphered ----");
        System.out.println(ciphervalue);
        System.out.println("--- ciphered ----");
        
        byte[] decrypt = symetric.decrypt(cipherText);
        String decipherValue = new String(decrypt, "UTF8");
        System.out.println("--- deciphered ----");
        System.out.println(decipherValue);
        System.out.println("--- deciphered ----");
    }
    
    private static void asymmetric() throws Exception {
        byte[] plainText = "Hello World".getBytes("UTF8");
        
        Asymetric asymetric = new Asymetric();
        byte[] cipherText = asymetric.encrypt(plainText);
        
        String ciphervalue = new String(cipherText, "UTF8");
        System.out.println("--- ciphered ----");
        System.out.println(ciphervalue);
        System.out.println("--- ciphered ----");
        
        byte[] decrypt = asymetric.decrypt(cipherText);
        String decipherValue = new String(decrypt, "UTF8");
        System.out.println("--- deciphered ----");
        System.out.println(decipherValue);
        System.out.println("--- deciphered ----");
    }
}
