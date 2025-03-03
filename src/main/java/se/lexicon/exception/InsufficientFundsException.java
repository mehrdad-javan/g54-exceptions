package se.lexicon.exception;

public class InsufficientFundsException extends Exception {

    private double currentBalance;
    private double withdrawalAmount;

    public InsufficientFundsException(String message, double currentBalance, double withdrawalAmount) {
        super(message);
        this.currentBalance = currentBalance;
        this.withdrawalAmount = withdrawalAmount;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    @Override
    public String toString() {
        return "Message: " + super.getMessage() + " , CurrentBalance=" + currentBalance + " , WithdrawalAmount=" + withdrawalAmount;
    }
}
