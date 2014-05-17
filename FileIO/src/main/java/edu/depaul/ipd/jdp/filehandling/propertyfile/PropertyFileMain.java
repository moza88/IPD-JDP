package edu.depaul.ipd.jdp.filehandling.propertyfile;

import java.io.FileReader;
import java.util.Properties;

/*
 * Example using Properties with location specified
 */
public class PropertyFileMain {
    public static void main(String[] args) throws Exception {
        Properties prop = new Properties();
        prop.load(new FileReader("/tmp/config.properties"));
        System.out.println(prop.toString());
    }
}
