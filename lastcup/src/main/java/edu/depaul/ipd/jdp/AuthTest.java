package edu.depaul.ipd.jdp;

import java.security.PrivilegedAction;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

public class AuthTest {
    public static void main(String[] args) throws Exception {
           //  System.setSecurityManager(new SecurityManager());
         LoginContext context = new LoginContext("Login1");
         context.login();
         System.out.println("Authentication successful.");
         Subject subject = context.getSubject();
         System.out.println("subject=" + subject);
         PrivilegedAction<String> action = new SysPropAction(args[0]);
         String result = Subject.doAsPrivileged(subject, action, null);
         System.out.println(result);
         context.logout();
    }
}

class SysPropAction implements PrivilegedAction<String>
{
   private String propertyName;

   /**
      Constructs an action for looking up a given property.
      @param propertyName the property name (such as "user.home")
   */
   public SysPropAction(String propertyName) { this.propertyName = propertyName; }

   public String run()
   {
      return System.getProperty(propertyName);
   }
}

