package edu.depaul.ipd.jdp.main;

import edu.depaul.ipd.jdp.lastcup.Account;
import edu.depaul.ipd.jdp.lastcup.CommonsAccount;
import edu.depaul.ipd.jdp.lastcup.SimplePersister;
import java.util.HashSet;

/**
 *
 * Main runner
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");
        Account a1 = new Account(1, "Dave");
//        System.out.println(a1);
        Account a2 = new Account(1, "Dave");
//        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));
//        HashSet<Account> set = new HashSet<Account>();
//        set.add(a1);
//        set.add(a2);
//        System.out.println(set);
        
       CommonsAccount ca1 = new CommonsAccount(1, "Dave");
//        CommonsAccount ca2 = new CommonsAccount(1, "Dave2");
//        HashSet<CommonsAccount> set = new HashSet<CommonsAccount>();
//        set.add(ca1);
//        set.add(ca2);
//        System.out.println(set);

        SimplePersister.saveXml(ca1);
    }
}
