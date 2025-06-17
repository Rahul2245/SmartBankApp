import services.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.loadData();  
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n======  Smart Bank App ======");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Account Details");
            System.out.println("5. List All Accounts");
            System.out.println("6. Save Data");
            System.out.println("7. Exit");
            System.out.println("8. Simulate Multithreading Transaction");

            System.out.print("Enter your choice: ");
            
            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> bank.createAccount();
                    case 2 -> bank.depositMoney();
                    case 3 -> bank.withdrawMoney();
                    case 4 -> bank.viewAccount();
                    case 5 -> bank.listAllAccounts();
                    case 6 -> bank.saveData();
                    case 7 -> {
                        bank.saveData();  
                        System.out.println("👋 Exiting... Goodbye!");
                    }
                   case 8 -> {
    System.out.print("Enter account number: ");
    String accNo = sc.nextLine();
    System.out.print("Enter number of threads: ");
    int n = Integer.parseInt(sc.nextLine());
    System.out.print("Enter transaction type (deposit/withdraw): ");
    String type = sc.nextLine();
    bank.simulateMultithreadedTransactions(accNo, n, type);
}

                    default -> System.out.println(" Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println(" Error: Invalid input.");
                choice = 0; 
            }

        } while (choice != 7);
    }
}
