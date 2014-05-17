package edu.depaul.ipd.jdp.lastcup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  Example to show different logging configuration options
 */
public class AccountTest {
    @BeforeClass
    public static void setUpClass() throws IOException {
        LogManager.getLogManager().readConfiguration(
                Thread.currentThread().getContextClassLoader().
                        getResourceAsStream("log.filehandler.properties"));
    }
    
    @Test
    public void equalAccountTest() {
        Account a1 = new Account(1, "Dave");
        Account a2 = new Account(1, "Dave");
        assertEquals(a1, a2);
    }
    
    @Test
    public void sameAccountTest() {
        Account a1 = new Account(1, "Dave");
        Account a2 = new Account(1, "Dave");
        assertNotSame(a1, a2);
    }
}
