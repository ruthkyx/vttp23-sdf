package src.bankacc1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankAccount {
    
    private final String name;
    private final String accNum;
    private float balance;
    private List <String> transactions = new ArrayList<>();
    private boolean isClosed; 
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime closeDate;

    BankAccount(String name) {
        this.name = name; 
        this.balance = 0;
        this.accNum = generateAccNum();
    }

    BankAccount(String name, float balance) {
        this.name = name;
        this.balance = balance;
        this.accNum = generateAccNum();
    }

    public void deposit(float dep) {
        if (isClosed != true || dep < 0) {
            this.balance += dep;
            transactions.add("$" + dep + " deposited at <" + LocalDateTime.now() + ">");
            System.out.println("An amount of $" + dep + " has been deposited at " + LocalDateTime.now());
        } else {
            throw new IllegalArgumentException ("Check that your account is still active & deposit amount is non-negative!");
        }

    }

    public void withdrawal (float withdraw) {
        if (isClosed != true || withdraw < 0) {
            this.balance -= withdraw;
            transactions.add("$" + withdraw + " withdrawn at <" + LocalDateTime.now() + ">");
            System.out.println("An amount of $" + withdraw + " has been withdrawn at " + LocalDateTime.now());
        } else {
            throw new IllegalArgumentException ("Check that your account is still active & withdrawal amount is non-negative!");
        }

    }

    private String generateAccNum () {
        int length = 12;
        
        // StringBuilder object to concatenate multiple values
        StringBuilder generatedNum = new StringBuilder();
        Random random = new Random();

        // ensure the first digit is not 0 by adding 1 to the result of random.nextInt(9), which generates a random int from 1-9(inclusive)
        // note that bound is 9 instead of 10 bcos range of 0-8 is generated and adding 1 will shift range to 1-9, preventing 0 from being generated
        generatedNum.append(1 + random.nextInt(9));

        // generates the remaining digits. i starts from1 bcos 1st digit alrdy appended. bound value 10 is excluded
        for (int i = 1; i < length; i++) {
            generatedNum.append(random.nextInt(10));
        }

        return generatedNum.toString();
    }

    // setAccNum & setName has been removed as the number is immutable
    public String getName() {return name;}
    public String getAccNum() {return accNum;}

    public float getBalance() {return balance;}
    public void setBalance(float balance) {this.balance = balance;}

    public List<String> getTransactions() {
        List<String> formattedTransactions = new ArrayList<>();
        for (String transaction : transactions) {
            formattedTransactions.add(transaction + "\n");
        }
        return formattedTransactions;
    }
    public void setTransactions(List<String> transactions) {this.transactions = transactions;}

    public boolean isClosed() {return isClosed;}
    public void setClosed(boolean isClosed) {this.isClosed = isClosed;}

    public LocalDateTime getCreateDate() {return createDate;}
    public void setCreateDate(LocalDateTime createDate) {this.createDate = createDate;}

    public LocalDateTime getCloseDate() {return closeDate;}
    public void setCloseDate(LocalDateTime closeDate) {this.closeDate = closeDate;}

}
