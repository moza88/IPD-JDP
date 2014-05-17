package edu.depaul.ipd.jdp.filehandling;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileWithTokenMain {

    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("/tmp", "config.txt");
        List<String> lines = Files.readAllLines(path);
        lines.stream().forEach((line) -> {
            String[] tokens = line.split(";");
            for (String token : tokens) {
                System.out.print(token);
                System.out.print(" ");
            }
        });
    }

}
