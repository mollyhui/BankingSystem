import java.io.Serializable;

public abstract class Account  implements Serializable{
    private double balance = 0;
    private double interest = 0.02;
    private int accountNumber;
    private static int numberOfAccounts = 1000000;
    private double transactionFee;
    
    Account(){
        this.accountNumber = getNextAccountNumber();
    }
    
    public int getAccountNumber() {
        return this.accountNumber;
    }
    
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public static int getNextAccountNumber(){
        return ++numberOfAccounts;
    }
    
    public abstract String getAccountType();

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return this.interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    
    
    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount + transactionFee > balance){
            throw new InsufficientFundsException();
        }
        balance -= amount + transactionFee;
    }
    
    public void deposit(double amount) throws InvalidAmountException{
        if(amount <= 0){
            throw new InvalidAmountException();
        }
        amount = amount + amount * interest;
        balance += amount;
    }

    public double getTransactionFee() {
        return transactionFee;
    }
    
    public void setTransactionFee(double fee){
        this.transactionFee = fee;
    }



}

