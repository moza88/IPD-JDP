package edu.depaul.ipd.jdp.lastcup;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.logging.Logger;

public class SimplePersister {
        private static final Logger LOG = Logger.getLogger(SimplePersister.class.getName());

    private static final String XML_FILE_NAME = "mybean.xml";
    /**
     * Save the content of object in xml file
     * @param obj
     * @throws IOException 
     */
    public static void saveXml(Object obj) throws IOException {
            try (XMLEncoder encoder = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream(XML_FILE_NAME)))) {
                encoder.writeObject(obj);
            }
    }
    
    /**
     * Read the content of object in xml file
     * @return 
     * @throws IOException 
     */
    public static Object readXml() throws IOException {
        Object object;
            try (XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream(XML_FILE_NAME)))) {
                object = decoder.readObject();
            }
        return object;
    }
    
    private static final String SERIAL_FILE_NAME = "mybean.ser";
    
    /**
     * Save the content of object in serialization file
     * @param obj
     * @throws IOException 
     */
    public static void saveObject(Object obj) throws IOException {
            try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream(SERIAL_FILE_NAME))) {
                out.writeObject(obj);
            }        
    }
    
    /**
     * Save the content of object in serialization file
     * @return 
     * @throws IOException 
     * @throws java.lang.ClassNotFoundException 
     */
    public static Object readObject() throws IOException, ClassNotFoundException {
        File file = new File(SERIAL_FILE_NAME);
        Object object;
            // Deserialize the object
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                // Deserialize the object
                object = in.readObject();
            }
        return object;
    }
}
