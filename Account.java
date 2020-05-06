import java.io.Serializable;

public abstract class Account implements Serializable{
    private double balance = 0;
    private double interest = 0;
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
    
    public void withdraw(double money) throws InsufficientFundsException{
    	//update manager's balance(transaction fee, interest)
        //double manager_balance = AppBackup.getBalanceOfManagers();
        //AppBackup.changeAttributeOfAll("manager", 3, this.transactionFee + manager_balance);
        if(money+ this.transactionFee > balance){
            throw new InsufficientFundsException();
        }
        balance -= money+this.transactionFee;
    }
    
    public void deposit(double amount) throws InvalidAmountException{
        //double manager_balance = AppBackup.getBalanceOfManagers();
    	//update manager's balance(transaction fee, interest)
        if(amount <= 0){
            throw new InvalidAmountException();
        }
        amount = amount + amount * interest;
        balance += amount;
    }
    
    public void transfer(Account account, double amount) throws Exception{
    	//TODO: update manager's balance(transaction fee, interest)
    	//Manager manager = new Manager();
		if(amount + this.getTransactionFee() > this.getBalance()){
            throw new InsufficientFundsException();
        }else{
        	this.setBalance(this.getBalance()-amount-this.getTransactionFee());
        	account.setBalance(account.getBalance() + amount);
        	//manager.setBalance(this.getTransactionFee());
        }
	}

    public double getTransactionFee() {
        return transactionFee;
    }
    
    public void setTransactionFee(double fee){
        this.transactionFee = fee;
    }



}

