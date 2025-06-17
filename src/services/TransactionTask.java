package services;

import models.Account;

public class TransactionTask implements Runnable {

     private Account account;
    private String type;
    private double amount;

    public TransactionTask(Account account, String type, double amount) {
        this.account = account;
        this.type = type;
        this.amount = amount;
    }
        @Override
    public void run() {
        if ("deposit".equalsIgnoreCase(type)) {
            account.deposit(amount);
        } else if ("withdraw".equalsIgnoreCase(type)) {
            account.withdraw(amount);
        } else {
            System.out.println(" Invalid transaction type.");
        }
    }


    
}
