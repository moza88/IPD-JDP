package edu.depaul.ipd.jdp.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Example showing insert
 */
public class AccountInserter extends AbstractAccountJDBCHandler {

    /**
     * Add new account
     *
     * @param acct - account information to insert
     * @return whether add was successful or not
     */
    public boolean add(Account acct) {
        int numOfRows = 0;
        try ( Connection con = getConnection(); 
                Statement stmt = con.createStatement()) {
            // Step 4:  Get the resultset from the result of executing a query
            numOfRows = stmt.executeUpdate("insert into accounts(id, name, balance) values "
                    + "(" + acct.getAccountNumber() + ", "
                    + " '" + acct.getName() + "', "
                    + acct.getBalance() + ")");
        } catch (SQLException sql) {
            throw new RuntimeException(sql);
        }

        return (numOfRows == 1);

    }

}
