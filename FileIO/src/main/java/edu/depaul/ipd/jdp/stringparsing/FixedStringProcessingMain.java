package edu.depaul.ipd.jdp.stringparsing;

/**
 * Example showing string processing using fixed length position
 */
public class FixedStringProcessingMain {

    public static void main(String[] args) {
        String line = "01;John;100";
        System.out.print(line.substring(0, 2));
        System.out.print("--");
        System.out.print(line.substring(3, 7));
        System.out.print("++");
        System.out.print(line.substring(8, 10));
        System.out.println();
    }

}
