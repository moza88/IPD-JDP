package edu.depaul.ipd.jdp.filehandling.propertyfile;

import java.io.IOException;
import java.util.Properties;

/**
 * Property file in xml
 */
public class PropertyFileXmlMain {

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        ClassLoader cl = PropertyFileXmlMain.class.getClassLoader();

        prop.loadFromXML(cl.getResourceAsStream("config.xml"));
        System.out.println(prop.toString());
    }

}
