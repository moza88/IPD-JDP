package edu.depaul.ipd.jdp.filehandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Example showing how to open the file from classpath rather than hard coded path
 */
public class FileFromClassPathMain {
    public static void main(String[] args) throws IOException {
        InputStream stream = FileFromClassPathMain.class.getClassLoader()
            .getResourceAsStream("config.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
    
}
