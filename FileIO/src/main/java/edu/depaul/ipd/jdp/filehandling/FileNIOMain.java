/*
 * Example using NIO, post JDK6
 */
package edu.depaul.ipd.jdp.filehandling;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * File IO using Post JDK7 nio
 */
public class FileNIOMain {

    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("/tmp", "config.txt"); 
        List<String> lines = Files.readAllLines(path);
        lines.stream().forEach((line) -> {
            System.out.println(line);
        });
    }
}
