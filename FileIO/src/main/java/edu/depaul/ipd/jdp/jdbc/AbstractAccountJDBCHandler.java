package edu.depaul.ipd.jdp.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to handle database connection
 */
public abstract class AbstractAccountJDBCHandler {
    private static final Properties prop = new Properties();

    static {
        try {
            try {
                prop.load(AbstractAccountJDBCHandler.class.getClassLoader().getResourceAsStream("config.properties"));
            } catch (IOException ex) {
                Logger.getLogger(AccountFinder.class.getName()).log(Level.SEVERE, null, ex);
            }
            Class.forName(prop.getProperty("db.driver"));
        } catch (ClassNotFoundException ex) {
                Logger.getLogger(AccountFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                prop.getProperty("db.connectionurl"),
                prop.getProperty("db.userid"),
                prop.getProperty("db.password"));
    }
    
}
