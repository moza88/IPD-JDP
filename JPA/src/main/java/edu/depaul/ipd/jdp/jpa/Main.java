package edu.depaul.ipd.jdp.jpa;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        JPAAccountManager am = new JPAAccountManager();
        
        Account account = am.findAccount(100);
        System.out.println(account);
        
        List<Account> accounts = am.getAllAccounts();
        System.out.println(accounts);
        
        Account a = new Account();
        a.setId(200);
        a.setName("Dave");
        a.setBalance(200.00);
        am.saveAccount(a);
        
        System.out.println(am.getAllAccounts());
    }
}
