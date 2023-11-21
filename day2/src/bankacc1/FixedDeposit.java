package src.bankacc1;

public class FixedDeposit extends BankAccount {

    private float interest = 3;
    private Integer duration = 6;
    private boolean interestChanged = false; 
    private boolean durationChanged = false; 

    public FixedDeposit(String name, float balance) {
        super(name, balance);
    }

    public FixedDeposit(String name, float balance, float interest) {
        super(name, balance);
        this.interest = interest;
    }

    public FixedDeposit(String name, float balance, float interest, Integer duration) {
        super(name, balance);
        this.interest = interest;
        this.duration = duration;
    }

    public float getInterest() {return interest;
    }
    public void setInterest(float newInterest) {
        if (interestChanged) {
            throw new IllegalArgumentException();
        }
        this.interest = newInterest;
        this.interestChanged = true;
    }

    public Integer getDuration() {return duration;}
    public void setDuration(Integer newDuration) {
        if (durationChanged) {
            throw new IllegalArgumentException();
        }
        this.duration = newDuration; 
        this.durationChanged = true;
    }

    @Override
    public float getBalance() {
        // return balance + interest
        float newBalance = super.getBalance();
        return (newBalance + (newBalance *(interest/100)));
    }

    @Override
    public void deposit(float dep) {
        // no operation means this method wont be executed when called
        System.out.println("Deposit not allowed.");
    }

    @Override
    public void withdrawal(float withdraw) {
        System.out.println("Withdrawal not allowed.");
    }
}