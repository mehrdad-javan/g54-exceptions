package se.lexicon;

import se.lexicon.exception.ExceptionHandler;
import se.lexicon.exception.InsufficientFundsException;
import se.lexicon.model.BankAccount;

public class Main {
    public static void main(String[] args) {
        try {
            BankAccount account = new BankAccount();
            account.deposit(100);
            System.out.println(account);
            //account.deposit(-10);
            account.withdraw(500);
            System.out.println(account);
        } catch (Exception e){
            ExceptionHandler.handleException(e);
        }

    }
}