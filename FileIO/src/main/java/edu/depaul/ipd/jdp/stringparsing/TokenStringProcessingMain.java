package edu.depaul.ipd.jdp.stringparsing;

/**
 * Example showing string processing using token
 */
public class TokenStringProcessingMain {

    public static void main(String[] args) {
        String line = "1;John;100";
        String[] tokens = line.split(";");
        for (String token : tokens) {
            System.out.print(token);
            System.out.print(" ");
        }
        System.out.println();

    }
}
