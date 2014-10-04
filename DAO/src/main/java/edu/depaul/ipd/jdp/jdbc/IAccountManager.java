package edu.depaul.ipd.jdp.jdbc;

import java.util.List;


public interface IAccountManager {

    Account findAccount(int acctNbr);
 
    List<Account> getAllAccounts();
}
