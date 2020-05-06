import java.io.Serializable;

public abstract class Account implements Serializable{
    private double balance = 0;
    private double interest = 0;
    private int accountNumber;
    private static int numberOfAccounts = 1000000;
    private double transactionFee;
    private String transactionType;

	
    
    Account(){
        this.accountNumber = getNextAccountNumber();
    }

    public String getTransactionType(){
        return this.transactionType;
    }

    public void setTransactionType(String transactionType){
        this.transactionType = transactionType;
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
    
    public void withdraw(double money) throws Exception{
    	//update manager's balance(transaction fee)
        int manager_balance = AppBackup.getBalanceOfManagers();
        AppBackup.changeAttributeOfAll("manager", 3, Double.toString((int)this.transactionFee + manager_balance));
        if(money+ this.transactionFee > balance){
            throw new InsufficientFundsException();
        }
        balance -= money+this.transactionFee;
    }
    
    public void deposit(double amount) throws Exception{
    	//update manager's balance(transaction fee)
        int manager_balance = AppBackup.getBalanceOfManagers();
        AppBackup.changeAttributeOfAll("manager", 3, Double.toString((int)this.transactionFee + manager_balance));
        if(amount <= 0){
            throw new InvalidAmountException();
        }
        amount = amount + amount * interest;
        balance += amount;
    }
    
    public void transfer(Account account, double amount) throws Exception{
    	//update manager's balance(transaction fee)
        int manager_balance = AppBackup.getBalanceOfManagers();
        AppBackup.changeAttributeOfAll("manager", 3, Double.toString((int)this.transactionFee + manager_balance));
		if(amount + this.getTransactionFee() > this.getBalance()){
            throw new InsufficientFundsException();
        }else{
        	this.setBalance(this.getBalance()-amount-this.getTransactionFee());
        	account.setBalance(account.getBalance() + amount);
        }
	}

    public double getTransactionFee() {
        return transactionFee;
    }
    
    public void setTransactionFee(double fee){
        this.transactionFee = fee;
    }



}

