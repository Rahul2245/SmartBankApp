💳 SmartBankApp - Java OOP Project
A simple yet powerful Bank Management System built using Java OOP, with features like:

Account creation (Savings / Current)
Deposits and Withdrawals
Transaction history (file logging)
Auto-generated account numbers
Multithreaded transaction simulation
Exception and error handling
Modular code with packages
📂 Project Structure
Bank Management System/ │ ├── src/ │ ├── Main.java │ ├── Bank.java │ ├── models/ │ │ ├── Account.java │ │ ├── SavingsAccount.java │ │ └── CurrentAccount.java │ └── services/ │ └── TransactionTask.java │ ├── README.md ├── .gitignore

yaml Copy Edit

🛠️ How to Run
🖥️ Compile
From the src/ folder:

javac -d . Main.java models/*.java services/*.java
▶️ Run
bash
Copy
Edit
java Main
🧪 Features Demonstrated
✅ Java OOP (Inheritance, Polymorphism)

✅ File handling (transaction.txt)

✅ Exception handling

✅ Multithreading using Runnable & Thread

✅ Static members for account ID management

🚀 Future Enhancements
GUI using Swing or JavaFX

Web-based interface using Spring Boot

Data storage in a real database (MySQL / MongoDB)

Unit testing with JUnit
