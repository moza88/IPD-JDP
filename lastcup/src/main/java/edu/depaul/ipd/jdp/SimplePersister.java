package edu.depaul.ipd.jdp;

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
        XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                new FileOutputStream(XML_FILE_NAME)));
        encoder.writeObject(obj);
        encoder.close();
    }
    
    /**
     * Read the content of object in xml file
     * @param obj
     * @throws IOException 
     */
    public static Object readXml() throws IOException {
        XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(
                new FileInputStream(XML_FILE_NAME)));
        Object object = decoder.readObject();
        decoder.close();
        return object;
    }
    
    private static final String SERIAL_FILE_NAME = "mybean.ser";
    
    /**
     * Save the content of object in serialization file
     * @param obj
     * @throws IOException 
     */
    public static void saveObject(Object obj) throws IOException {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(SERIAL_FILE_NAME));
        out.writeObject(obj);
        out.close();        
    }
    
    /**
     * Save the content of object in serialization file
     * @param obj
     * @throws IOException 
     */
    public static Object readObject() throws IOException, ClassNotFoundException {
        File file = new File(SERIAL_FILE_NAME);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        // Deserialize the object
        Object object =  in.readObject();
        in.close();
        return object;
    }
}
