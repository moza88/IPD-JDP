package edu.depaul.ipd.jdp;

import java.util.HashSet;

/**
 *
 * Main runner
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        //System.setProperty("java.security.policy", "PermissionTest.policy");
        //System.setProperty("java.security.policy", "NoPermission.policy");
        System.out.println(System.getProperty("java.security.policy"));
        System.setSecurityManager(new SecurityManager());

        Account a1 = new Account(1, "Dave");
        SimplePersister.saveXml(a1);
    }
}
