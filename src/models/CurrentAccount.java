package models;

import services.Bank;

public class CurrentAccount extends Account{
     private final double Overdraftlimit=-10000.00;
     public CurrentAccount(String Accountnumber,String Holdername, double Balance){
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
        if(amount<=0){
             System.out.println("withdrawn amount should be more than zero");
            return;
        }
        if(Balance-amount<Overdraftlimit){
            System.out.println("the amount is reached over Overdraftlimit");
            return;
        }
        Balance-=amount;
        System.out.println(amount+" withdrawn from your account");
        Bank.logTransaction(Accountnumber, "Withdraw", amount, Balance);
    }
}
