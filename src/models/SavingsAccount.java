package models;

import services.Bank;

public class SavingsAccount extends Account {
    private final double Withdrawlimit=50000.00;
    public SavingsAccount(String Accountnumber,String Holdername, double Balance){
        super(Accountnumber, Holdername, Balance);

    }
    public void deposit(double amount){
        if(amount<=0){
            System.out.println("deposit amount should be more than zero");
            return;

        }
        Balance+=amount;
        System.out.println(amount+" deposited into your account");
        Bank.logTransaction(Accountnumber, "Deposit", amount, Balance);
    }
     public void withdraw(double amount){
        if(amount>Withdrawlimit){
            System.out.println("withdraw amount is greater than withdrawn limit");
            return;
        }
        if(amount<=0){
            System.out.println("amount should be greater than zero");
            return;
        }
        if(Balance-amount<0){
            System.out.println("Insufficient funds");
            return;
        }
        Balance-=amount;
        System.out.println(amount+" debited from your accoount");
        Bank.logTransaction(Accountnumber, "Withdraw", amount, Balance);
     }
}
