package com.satya.testfileservice.filetest;

import com.satya.testfileservice.domain.Row;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Satya on 11/25/19.
 */
public class ScannerTest {
    public static void main(String args[]) {
        List<Row> seatingRows = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/data/master_tickets.txt"));
            while(scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split("\\|");
                Row row = new Row();
                Boolean[] seats = new Boolean[tokens.length];
                int i = 0;
                for(String token: tokens) {
                    System.out.println("token:"+token);
                    seats[i++] = token.equals("0") ? true:false;
                }
                row.setSeats(seats);
                seatingRows.add(row);
            }
            for(Row row: seatingRows) {
                System.out.println("Row seat count:"+row.availableSeats());
                System.out.println("Check for consectutive seats:"+row.checkSeats(2));
                System.out.println("Allocate seats:"+row.fillSeats(2));
                System.out.println("After allocating Row seat count:"+row.availableSeats());
                System.out.println("Print again Check for consectutive seats:"+row.checkSeats(2));

            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
