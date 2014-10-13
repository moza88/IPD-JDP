package edu.depaul.ipd.jdp.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

public class Main {

    public static void main(String[] args) {
   //     DBUtility.setupTable();
        JDBCAccountManager manager = new JDBCAccountManager();
        System.out.println(manager.findAccount(100));

        System.out.println("== After update ===");
        manager.updateBalance(100, 110);
        System.out.println(manager.findAccount(100));
        
        System.out.println("--");
        System.out.println(manager.getAllAccounts());

        /*
        System.out.println("== ResultSet ===");
        ResultSet set2 = manager.getAllAccountsAsResultSet();
        try {
            while (set2.next()) {
                System.out.println(set2.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("==");
        */
        
        System.out.println("== RowSet ===");
        CachedRowSet set = manager.getAccountsAsRowSet();
        try {
            while (set.next()) {
                System.out.println(set.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("==");
        
        
    }
}
