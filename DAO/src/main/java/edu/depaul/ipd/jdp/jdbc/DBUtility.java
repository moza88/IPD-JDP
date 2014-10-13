package edu.depaul.ipd.jdp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Performs some utilities functionality related to account
 */
public class DBUtility {

    private static final String IN_MEMORY_URL = "jdbc:hsqldb:mem:.";
    private static final String FILE_URL = "jdbc:hsqldb:hsql://localhost/xdb";
    
    public static final String DB_DRIVER = "org.hsqldb.jdbcDriver";
    public static final String DB_URL = FILE_URL;
    public static final String USER_NAME = "SA";
    public static final String PASSWORD = "";

    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    
    public static void setupTable() {
        String connectionUrl = DB_URL;
        String userName = USER_NAME;
        String password = PASSWORD;

        Connection con;
        try {
            con = DriverManager
                    .getConnection(connectionUrl, userName, password);
			// Step 3: Create a statement where the SQL statement will be
            // provided
            Statement stmt = con.createStatement();
            stmt.executeUpdate("create table accounts(id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 100) PRIMARY KEY, name varchar(50), balance decimal(15,2))");
            stmt.executeUpdate("INSERT INTO accounts (name, balance) values('George', 100)");
            stmt.executeUpdate("INSERT INTO accounts (name, balance) values('Paul', 100)");
            stmt.executeUpdate("INSERT INTO accounts (name, balance) values('Ringo', 1000)");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
