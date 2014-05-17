
package edu.depaul.ipd.jdp.security.encryption;

import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;

/**
 * Example to show asymetric (public/private) key combo
 */
public class Asymetric {

    private KeyPair key;
    private Cipher cipher;

    public Asymetric() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(1024);
            key = keyGen.genKeyPair();
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Symetric.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Symetric.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public byte[] encrypt(byte[] plainText) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, key.getPublic());
        return cipher.doFinal(plainText);
    }

    public byte[] decrypt(byte[] encryptedText) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException {
        // What happens if we were to change this to public key???
        cipher.init(Cipher.DECRYPT_MODE, key.getPrivate());
        return cipher.doFinal(encryptedText);
    }
}
