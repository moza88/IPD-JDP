package edu.depaul.ipd.jdp.security;

import java.security.MessageDigest;

/**
 * Message digest example
 */
public class MDMain {
    public static void main(String[] args) throws Exception {
        String algname = args.length >= 2 ? args[1] : "SHA-1";
        MessageDigest alg = MessageDigest.getInstance(algname);
        byte[] input = args[0].getBytes("UTF8");
        byte[] hash = alg.digest(input);
        String d = "";
        for (int i = 0; i < hash.length; i++) {
            int v = hash[i] & 0xFF;
            if (v < 16) {
                d += "0";
            }
            d += Integer.toString(v, 16).toUpperCase() + " ";
        }
	System.out.println("Original: " + args[0]);
	System.out.print("MD: ");
        System.out.println(d);



    }
    
}
