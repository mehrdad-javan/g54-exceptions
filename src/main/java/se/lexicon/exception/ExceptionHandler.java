package se.lexicon.exception;

public class ExceptionHandler {

    public static void handleException(Exception exception) {
        switch (exception) {
            case IllegalArgumentException exInstance -> System.out.println(exInstance.getMessage());
            case InsufficientFundsException exInstance -> System.out.println("Transaction failed. " + exInstance.toString());
            default -> {
                System.out.println("unexpected error occurred");
                exception.printStackTrace();
            }
        }

    }
}
