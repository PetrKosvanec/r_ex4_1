package com.kosvanec.r_ex4_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 1. Write a program that prints the longest line in a file chosen by the user. If
 * several lines are all equally long, your program should print the first such line.
 *
 */
public class App {
    public static void main( String[] args )
    {
        new App().run();
    }
    public void run() {
        String prompt = "Input file: ";
        Scanner sysin = new Scanner(System.in);
        BufferedReader rd = openFileReader(sysin, prompt);
        String theLongestLine = "";
        theLongestLine = longestLine(rd);
        System.out.println("Longest line: " + theLongestLine);
    }
    /**
     * Asks the user for the file name, opens it for reading, and then returns
     * a BufferedReader for that file.
     * @param sysin Scanner for user input
     * @param prompt Prompt to display to the user
     * @return A BufferedReader for the specified file
     * @throws IOException If the file cannot be opened
     */
    private BufferedReader openFileReader(Scanner sysin, String prompt) {
        BufferedReader rd = null;
        while(rd == null) {
            try {
                System.out.print(prompt);
                String fileName = sysin.nextLine();
                System.out.println("Printing the opening file name: " + fileName);
                rd = new BufferedReader(new FileReader(fileName));
            } catch (IOException ex) {
                System.out.println("Can't open that file.");
            }
        }
        return rd;
    }
    /**
     * Reads the file line by line and returns the longest line.
     * @param rd BufferedReader for the file
     * @return The longest line in the file
     */
    private String longestLine(BufferedReader rd) {
        String longestLine = "";
        int longestLineLength = longestLine.length();
        String line;
        try {
            while ((line = rd.readLine()) != null) {
                if (line.length() > longestLineLength) {
                    longestLine = line;
                    longestLineLength = line.length();
                }
            }
        } catch (IOException ex) {
            System.out.println("Error reading file: " + ex.getMessage());
        } finally {
            try {
                rd.close();
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
        return longestLine;
    }
}
