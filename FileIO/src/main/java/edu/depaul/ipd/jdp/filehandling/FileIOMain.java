package edu.depaul.ipd.jdp.filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * File IO example using pre JDK7, this is very common
 */
public class FileIOMain {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("/tmp/config.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }}
    }
    
}