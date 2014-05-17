package edu.depaul.ipd.jdp.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC implementation
 */
public class AccountFinder extends AbstractAccountJDBCHandler {

    /**
     * Moved the code from jdbc.Main to a class so that it can be reused
     */
    public Account find(int acctNbr) {
        Account account = new Account(acctNbr);

        try ( // Step 2:  Request a connection from the DriverManager
                Connection con = getConnection(); // Step 3:  Create a statement where the SQL statement will be provided
                Statement stmt = con.createStatement(); // Step 4:  Get the resultset from the result of executing a query
                ResultSet rs = stmt.executeQuery("select name, balance from accounts where id=" + acctNbr)) {

            // Step 5:  Processing the result
            while (rs.next()) {
                account.setName(rs.getString("name"));
                account.setInitialBalance(rs.getDouble("balance"));
            }

        } catch (SQLException sql) {
            throw new RuntimeException(sql);
        }

        return account;
    }
}