/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.ipd.jdp.security.encryption;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;

/**
 * Example to show symetric (private) key
 */
public class Symetric {
    private Key key;
    private Cipher cipher;
    
    public Symetric() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("DES");
            keyGen.init(56);
            key = keyGen.generateKey();
            cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Symetric.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Symetric.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public byte[] encrypt(byte[] plainText) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(plainText);
    }
    
    public byte[] decrypt(byte[] encryptedText)throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(encryptedText);
    }
}

