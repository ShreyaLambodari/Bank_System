# Bank_Managenment_System
A GUI-based Bank Management System developed in Java using Swing for user interface, JDBC for database connectivity and MYSQL for backend data storage.

## 📌 FEATURES:
✅ Account creation with automatic Account Number and PIN generation.

✅ User LOGIN Authetification.

✅ Deposit, Fast Cash, Help and Withdrawl functionality.

✅ Input Validations and Alert popups.

✅ Organized modular structure using Java Packages.

✅ Planned: Mini-Statement and Balance Enquiry modules.

## 🛠️ TECH STACK:
-> **Frontend**: Java Swing(GUI)

-> **Backend**: Java JDBC

-> **Database**: MYSQL

-> **IDE Used**: VS Code

## 🎯 Concepts Applied:
-> Object Oriented Design

-> GUI Components

-> JDBC Connectivity with CRUD Operations

-> EXception Handling

-> Input validations

## 📂 Folder Structure
BANK_SYSTEM/
├── .vscode/
├── Bank_sys_project/
│   ├── Balance/
│   ├── Deposit/
│   ├── FastCash/
│   ├── Help/
│   ├── login_page/
│   ├── MiniStatement/
│   ├── Sign_up/
│   ├── Sign_up2/
│   ├── Sign_up3/
│   ├── Transaction/
│   ├── Withdrawl/
│   └── src_Bank_Connection/   
├── README.md

## ⚙️ How to Run the Project
-> Clone the repo:
git clone https://github.com/ShreyaLambodari/Bank_Management_System.git

-> Open in VS Code or your preferred IDE.

-> Setup MySQL and create a database bank.

-> Import the SQL script from the database/ folder or manually create tables using your existing table structure.

-> Update your MySQL username and password in DBConnection.java:

   Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/bank", "root", "your_password");
    
-> Run the Login.java or SignUp.java file to begin.



## 🎯 Learning Goals
GUI development using Java Swing

Database operations with JDBC

Real-time data flow from GUI to MySQL

Handling basic business logic (e.g., balance check before withdrawal)

 ## 📌 Future Enhancements:
✅ Mini Statement generation

✅ Account deletion option

✅ Admin panel for account approvals

✅ Password encryption using hashing

✅ GUI enhancements and custom themes



