package se.lexicon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) {

        // checked-exception:
        // Files.newBufferedReader(Paths.get("dir/skills.txt"));

        // unchecked-exception:
        // int[] numbers = {1,2,3,4};
        // System.out.println(numbers[5]);

        // System.out.println((takeDecimalInput()));
        //System.out.println((getDate()));
        //readTextFile();

        readImageAndCopy();
        System.out.println("DONE");
    }

    public static double takeDecimalInput() {
        Scanner scanner = new Scanner(System.in);
        Double input = null;
        while (true) {
            try {
                System.out.println("Enter a Number: ");
                input = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                scanner.next(); // discard invalid input
                //e.printStackTrace(); // Debugging: Prints exception details
                System.out.println("Invalid Input! Please enter a valid decimal number.");
            }
        }
        return input;
    }


    public static LocalDate getDate() {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null;
        while (true) {
            try {
                System.out.println("Enter a date (YYYY-MM-DD): ");
                String strInput = scanner.nextLine();
                date = LocalDate.parse(strInput);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date! Please Enter a valid  date in this format (YYYY-MM-DD)");
            }
        }

        return date;

    }

    public static void readTextFile() {
        // 1. newBufferedReader(Path path)
        // Used for reading large files.
        try {
            Path path = Paths.get("dir/skills.txt");
            BufferedReader reader = Files.newBufferedReader(path);
            reader.lines().forEach(line -> System.out.println(line));
            // Absolute and Relative path
            // Absolute Path: A complete path from the root directory
            // Specifies the full path to the file or directory

            // Relative Path
            // A path relative to the current working directory

            // use absolute path when the file location is fixed.
            // use relative path when working with files in the project directories.

            System.out.println("----------------");
            // https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
            // 2. readAllLines()
            // Suitable for small files where all lines are needed at once.
            List<String> stringList = Files.readAllLines(path);
            stringList.forEach(s -> System.out.println(s));

        } catch (InvalidPathException e) {
            System.out.println("Error: file path is not valid");
        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("IOException: Something went wrong while reading the file");
        } catch (Exception e) {
            System.out.println("Unexpected Exception: call support teams and repost this issue ");
            e.printStackTrace();
        }

    }


    public static void readImageAndCopy() {
        try {
            Files.copy(
                    Paths.get("source/java_logo.png"),
                    Paths.get("destination/new_java_logo.png"),
                    StandardCopyOption.REPLACE_EXISTING
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeTextToFileWithFinallyBlock() {
        BufferedWriter writer = null;
        Path filePath = Paths.get("dir/skills.txt");

        try {
            writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            writer.append("JavaScript");
            writer.newLine();

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            // Handle file I/O exceptions (e.g., file not found, write failure)
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // try-with-recourses for automatic resource management
    public static void writeTextToFile() {
        Path filePath = Paths.get("dir/skills.txt");
        try (
                BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        ) {

            writer.append("JavaScript");
            writer.newLine();

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            // Handle file I/O exceptions (e.g., file not found, write failure)
            e.printStackTrace();
        }
    }

}
