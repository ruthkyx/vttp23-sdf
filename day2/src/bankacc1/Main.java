package src.bankacc1;

import java.time.LocalDateTime;

public class Main {
    public static void main (String[] args) {
        // Creating an insance of BankAccount1 (aka creating a new bank acc object)
        BankAccount newAcc = new BankAccount("Ruth");

        // display initial info
        System.out.println("Account Holder: " + newAcc.getName());
        System.out.println("Account Number: " + newAcc.getAccNum());
        System.out.println("Account Balance: $" + newAcc.getBalance());
        System.out.println("Creation Date: " + newAcc.getCreateDate());

        // operations performed on the account 
        newAcc.deposit(200);
        newAcc.withdrawal(100);

        // display updated acc info 
        System.out.println("Updated Balance: $" + newAcc.getBalance());
        System.out.println("Transactions: \n" + newAcc.getTransactions());

        // close the account 
        newAcc.setClosed(true);
        newAcc.setCloseDate(LocalDateTime.now());

        // display final account information
        System.out.println("Account Closed: " + newAcc.isClosed());
        System.out.println("Closure Date: " + newAcc.getCloseDate());

        // fixed deposit acc
        FixedDeposit newFD = new FixedDeposit("Miffy", 100, 3, 6);
        System.out.println("Initial deposit: $" + newFD.getBalance());

        // testing that the deposit and withdraw method will perform no operations
        newFD.deposit(100);
        newFD.withdrawal(50);

        // test that the interest and duration can only be changed once 
        newFD.setInterest(5);
        newFD.setDuration(12);

        newFD.setInterest(10);
        newFD.setDuration(24);

        // check updated balance
        System.out.println("Updated balance: $" + newFD.getBalance());
    }
}
