package edu.depaul.ipd.jdp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Example showing update but also using PreparedStatement
 */
public class AccountUpdater extends AbstractAccountJDBCHandler {

    /**
     * Update account
     *
     * @param acct - account information to insert
     * @return whether add was successful or not
     */
    public boolean updateBalance(int acct, float newBalance) {
        int numOfRows = 0;
        try ( 
                Connection con = getConnection(); 
                PreparedStatement stmt = con.prepareStatement("update accounts set balance=? where id=?")) {
            
            stmt.setFloat(1, newBalance);
            stmt.setInt(2, acct);
            // Step 4:  Get the resultset from the result of executing a query
            numOfRows = stmt.executeUpdate();
        } catch (SQLException sql) {
            throw new RuntimeException(sql);
        }

        return (numOfRows == 1);

    }

}
