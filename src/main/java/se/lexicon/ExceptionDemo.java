package se.lexicon;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {

    public static void main(String[] args) {

        // checked-exception:
        // Files.newBufferedReader(Paths.get("dir/skills.txt"));

        // unchecked-exception:
        // int[] numbers = {1,2,3,4};
        // System.out.println(numbers[5]);

        // System.out.println((takeDecimalInput()));
        System.out.println((getDate()));
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


}
