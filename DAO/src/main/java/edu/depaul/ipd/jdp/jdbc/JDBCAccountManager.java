package edu.depaul.ipd.jdp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 * JDBC implementation
 */
public class JDBCAccountManager implements IAccountManager {

    private static final Logger LOG = Logger.getLogger(JDBCAccountManager.class.getName());

    static {
        try {
            Class.forName(DBUtility.DB_DRIVER);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBUtility.DB_URL, DBUtility.USER_NAME, DBUtility.PASSWORD);
    }

    @Override
    /**
     * Example showing usual pre JDK7 JDBC code
     */
    public Account findAccount(int acctNbr) {
        Account account = new Account(acctNbr);

        try {
            // Step 2:  Request a connection from the DriverManager
            Connection con = getConnection();

            // Step 3:  Create a statement where the SQL statement will be provided
            Statement stmt = con.createStatement();

            // Step 4:  Get the resultset from the result of executing a query
            ResultSet rs = stmt.executeQuery("select nm, balance from accounts where id=" + acctNbr);

            // Step 5:  Processing the result
            while (rs.next()) {
                account.setName(rs.getString("nm"));
                account.setInitialBalance(rs.getDouble("balance"));
            }

            // Step 6:  Closing the connection
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException sql) {
            throw new RuntimeException(sql);
        }

        return account;
    }

    @Override
    /**
     * Example showing recommended post JDK7 JDBC code using try with resource
     * to let the JVM close out the connection
     */
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();

        try (
                // Step 2:  Request a connection from the DriverManager
                Connection con = getConnection();
                // Step 3:  Create a statement where the SQL statement will be provided
                Statement stmt = con.createStatement();
                // Step 4:  Get the resultset from the result of executing a query
                ResultSet rs = stmt.executeQuery("select id, nm, balance from accounts");) {

            // Step 5:  Processing the result
            while (rs.next()) {
                Account account = new Account();
                account.setAccountNumber(rs.getInt("id"));
                account.setName(rs.getString("nm"));
                account.setInitialBalance(rs.getDouble("balance"));
                accounts.add(account);
            }
        } catch (SQLException sql) {
            throw new RuntimeException(sql);
        }

        return accounts;
    }

    /**
     * Example showing recommended post JDK7 JDBC code using try with resource
     * to let the JVM close out the connection
     * @return 
     */
    public ResultSet getAllAccountsAsResultSet() {
        ResultSet rs = null;

        try (
                // Step 2:  Request a connection from the DriverManager
                Connection con = getConnection();
                // Step 3:  Create a statement where the SQL statement will be provided
                Statement stmt = con.createStatement();
                ResultSet rs2 = stmt.executeQuery("select id, nm, balance from accounts");) {
            // Step 4:  Get the resultset from the result of executing a query

            rs = rs2;

        } catch (SQLException sql) {
            throw new RuntimeException(sql);
        }

        return rs;
    }

    /**
     * Example showing update using regular statement
     * @param accountNumber
     * @param newBalance 
     */
    public void updateBalance(int accountNumber, float newBalance) {
        try (
                // Step 2:  Request a connection from the DriverManager
                Connection con = getConnection();
                // Step 3:  Create a statement where the SQL statement will be provided
                Statement stmt = con.createStatement();) {

            stmt.executeUpdate("update accounts set balance = " + newBalance + " where id = " + accountNumber);
            // Step 4:  Get the resultset from the result of executing a query

        } catch (SQLException sql) {
            throw new RuntimeException(sql);
        }
    }

    /**
     * Example showing update using prepared statement
     * @param accountNumber
     * @param newBalance 
     */
    public void updatePreparedBalance(int accountNumber, float newBalance) {
        try (
                // Step 2:  Request a connection from the DriverManager
                Connection con = getConnection();
                // Step 3:  Create a statement where the SQL statement will be provided
                PreparedStatement stmt = con.prepareStatement("update accounts set balance = ? where id = ?" );) {

            stmt.setFloat(1, newBalance);
            stmt.setInt(2, accountNumber);
            stmt.executeUpdate();
            // Step 4:  Get the resultset from the result of executing a query

        } catch (SQLException sql) {
            throw new RuntimeException(sql);
        }
    }
    
    /**
     * Sends CachedRowSet which allows for disconnected results
     * @return 
     */ 
    public CachedRowSet getAccountsAsRowSet() {
        CachedRowSet crs2 = null;
        
        try (CachedRowSet crs  = RowSetProvider.newFactory().createCachedRowSet()){
            crs.setCommand("select id, nm, balance from accounts");
            crs.execute(getConnection());
            crs2 = crs;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCAccountManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return crs2;

    }
}
