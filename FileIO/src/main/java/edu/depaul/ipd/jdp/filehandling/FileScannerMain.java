package edu.depaul.ipd.jdp.filehandling;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
 * Example using Scanner
 */
public class FileScannerMain {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream stream = FileFromClassPathMain.class.getClassLoader()
            .getResourceAsStream("config.txt");
        try (Scanner scanner = new Scanner(stream)) {
            //Set the delimiter used in file
            scanner.useDelimiter(";");
            
            while (scanner.hasNext()) {
                System.out.print(scanner.next() + "-");
            }
        }
    }
}
