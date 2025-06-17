package services;

import services.BankOperations;
import models.Account;
import models.CurrentAccount;
import models.SavingsAccount;
import java.io.*;
import java.util.*;

public class Bank implements BankOperations {
   private Map<String,Account> accounts = new HashMap<>();
     private static final String DATA_FILE = "accounts.txt";
     private static final String TRANSACTION_FILE = "transactions.txt";
      private static int accountNumberSeed = 1001;
     Scanner sc = new Scanner(System.in);
    @Override
    public void createAccount() {
        System.out.println("enter the Holder Name");
        String name=sc.nextLine();
        System.out.println("Initial deposit :");
        double balance;
        try{
            balance=Double.parseDouble(sc.nextLine());
        }catch(NumberFormatException e){
            System.out.println("invalid deposit amount");
            return;
        }
        System.out.println("account type (1 for savings, 2 for current)");
        int type = sc.nextInt(); sc.nextLine();
        String accnumber = "CODE"+accountNumberSeed++;
        Account acc = null;

        if(type==1){
            acc = new SavingsAccount(accnumber, name, balance);
        }else if(type==2){
            acc= new CurrentAccount(accnumber, name, balance);
        }else{
            System.out.println("Inavlid account type");
            return;
        }
        accounts.put(accnumber, acc);
        System.out.println("congratulations your account has been succesfully setup. Account Number: "+ accnumber);


      
    }
    public void depositMoney(){
        System.out.println("enter your account number");
        String accnumber = sc.nextLine();
        Account ac = accounts.get(accnumber);

        if(ac==null){
            System.out.println("account not found");
            return;
        }
        System.out.println("enter the amount to deposit : ");
        try {
            double amount = Double.parseDouble(sc.nextLine());
            ac.deposit(amount);
        } catch (Exception e) {
            System.out.println("invalid amount");
        }

    }
    public void withdrawMoney(){
     System.out.println("enter your account number");
        String accnumber = sc.nextLine();
        Account ac = accounts.get(accnumber);

        if(ac==null){
            System.out.println("account not found");
            return;
        }
        System.out.println("enter the amount to withdraw : ");
        try{
             double amount = Double.parseDouble(sc.nextLine());
            ac.withdraw(amount);
        } catch (Exception e) {
            System.out.println("invalid amount");
        }}

        public void viewAccount(){
            System.out.println("enter the account number : ");
            String accnumber = sc.nextLine();
            Account acc = accounts.get(accnumber);
             if (acc != null) {
            System.out.println(acc);
        } else {
            System.out.println(" Account not found.");
        }
    

        }
        public void listAllAccounts(){
            if(accounts.isEmpty()){
                System.out.println("no accounts found.");
                return;
            }
            for(Account acc:accounts.values()){
                System.out.println("---------------");
                System.out.println(acc);
            }
        }
        public void saveData(){
            try(PrintWriter pw = new PrintWriter(new FileWriter(DATA_FILE))){
                for(Account acc : accounts.values()){
                    pw.println(acc.Getaccountnum()+","+acc.Getholdername()+","+acc.Getbalance()+","+acc.getClass().getSimpleName());
                }
                System.out.println("Data saved to file.");
            }catch(IOException e){
                System.out.println("Failed to save data");
            }

        }
         public void loadData(){
            File file = new File(DATA_FILE);
            if(!file.exists())return;
            try(BufferedReader br = new BufferedReader(new FileReader(file))){
                String line;
                while((line = br.readLine())!=null){
                    String[] parts = line.split(",");
                    String accnum = parts[0];
                    String name = parts[1];
                    double balance = Double.parseDouble(parts[2]);
                    String type = parts[3];

                    Account ac = type.equals("SavingsAccount")?new SavingsAccount(accnum, name, balance):new CurrentAccount(accnum, name, balance);
                    accounts.put(accnum, ac);
                    accountNumberSeed = Math.max(accountNumberSeed, Integer.parseInt(accnum.substring(3)) + 1);
                }
                System.out.println("Data loaded from file");
            }catch(IOException|NumberFormatException e){
                System.out.println("failed to load data");
            }
      




         }
         public static synchronized void logTransaction(String accNum, String type, double amount, double newBalance) {
    try (PrintWriter pw = new PrintWriter(new FileWriter(TRANSACTION_FILE, true))) {
        String log = String.format("%s | %s | ₹%.2f | New Balance: ₹%.2f | %s",
                accNum, type, amount, newBalance, new java.util.Date());
        pw.println(log);
    } catch (IOException e) {
        System.out.println(" Failed to write transaction log.");
    }
}
public void simulateMultithreadedTransactions(String accnum,int noofthreads,String type){
    Account ac =accounts.get(accnum);
    if(ac==null){
        System.out.println("Account not found");
        return;
    }
    Thread arr[]= new Thread[noofthreads];
      for (int i = 0; i < noofthreads; i++) {
        arr[i] = new Thread(new TransactionTask(ac, type, 5000));
        arr[i].start();
    }
    for (int i = 0; i < noofthreads; i++) {
        try {
            arr[i].join();
        } catch (InterruptedException e) {
            System.out.println(" Thread interrupted: " + e.getMessage());
        }
    }
    System.out.println(" All " + noofthreads + " " + type + " transactions completed.");
}

}

   
    

