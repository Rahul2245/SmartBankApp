package models;

public abstract class Account {
    protected String Accountnumber;
    protected String Holdername;
    protected double Balance;
     private static int totalAccounts = 0;
    public Account(String Accountnumber,String Holdername, double Balance){
        this.Accountnumber=Accountnumber;
        this.Holdername=Holdername;
        this.Balance=Balance;
        totalAccounts++;
    }
    public String Getaccountnum(){
        return Accountnumber;
    }
    public String Getholdername(){
        return Holdername;
    }
    public double Getbalance(){
        return Balance;
    }
    public String toString(){
        return "Account:{Account Number : "+Accountnumber+
              "Holder Name : "+Holdername+
              "Balance : "+Balance+"}"   ;
    
}
 public static int getTotalAccounts() {
        return totalAccounts;
    }
public abstract void deposit(double amount);
public abstract void withdraw(double amount);
}