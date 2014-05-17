package edu.depaul.ipd.jdp.filehandling.propertyfile;

import java.io.IOException;
import java.util.Properties;

/**
 * Example reading from classpath
 */
public class PropertyFileClasspathMain {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        ClassLoader cl = PropertyFileClasspathMain.class.getClassLoader(); 
        prop.load(cl.getResourceAsStream("config.properties"));
        System.out.println(prop.toString());
    }
}
