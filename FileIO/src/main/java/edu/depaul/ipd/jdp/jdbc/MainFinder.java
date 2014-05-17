package edu.depaul.ipd.jdp.jdbc;

/**
 * JDBC with simple class abstraction
 */
public class MainFinder {

    public static void main(String[] args) {
        AccountFinder manager = new AccountFinder();
        System.out.println(manager.find(100));
    }
}
