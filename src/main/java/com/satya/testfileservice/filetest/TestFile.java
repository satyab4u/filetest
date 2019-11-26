package com.satya.testfileservice.filetest;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Satya on 11/25/19.
 */
public class TestFile {
    public static void main(String args[]) throws Exception {
        Path path = Paths.get("src/main/resources/data/master_tickets.txt");
        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();
        while( line != null) {
           System.out.println("line:"+line);
           line = reader.readLine();
        }
    }
}
