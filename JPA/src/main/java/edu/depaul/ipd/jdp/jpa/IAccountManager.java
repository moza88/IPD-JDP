package edu.depaul.ipd.jdp.jpa;

import java.util.List;

public interface IAccountManager {

    /**
     *
     * @param acctNbr
     * @return
     */
    Account findAccount(int acctNbr);

    /**
     *
     * @return
     */
    List<Account> getAllAccounts();
}
