import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;


public class Customer extends User implements Serializable{
    private double walletAmount;
    private int creditScore;
    private Loan loan = null;
    
    private Hashtable<String, Account> account = new Hashtable<String, Account>();


    Customer(String firstName, String lastName, String ssn, String password, double walletAmount, int creditScore) {
        super(firstName, lastName, ssn, password);
        this.walletAmount = walletAmount;
        this.creditScore = creditScore;
    }

    /**
     * ADD ACCOUNT (checkings, savings, or securities)
     * exception: if that account type already exists
     */
    public void addBankAccount(String type, Account account) throws Exception{
    	if (!AccountAlreadyExisted(type)) this.account.put(type, account);
		else {
			throw new InvalidAccountException();
		}
    }
    
    public boolean AccountAlreadyExisted(String type){
    	boolean existed = false;
    	if (account.containsKey(type)) {
    		existed = true;
    	}
    	return existed;
    	
    }
    public Account getAccount(String type) {
    	return this.account.get(type);
    }
    
    public double getWalletAmount() {
        return walletAmount;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public String getAuthorization() {
        return "basic";
    }

    public void addToWallet(double amount) {
        this.walletAmount += amount;
    }

    public void subtractFromWallet(double amount) {
        this.walletAmount -= amount;
    }

    public void addLoan(Loan loan) throws TooManyLoansException{
        if (this.loan == null) {
            this.loan = loan;
        } else {
            throw new TooManyLoansException();
        }
    }

    public void makeLoanPayment() throws InsufficientFundsException{
        double loanPayment = loan.getMonthlyPayment();
        if (netWorthWithoutSecurity() < loanPayment){
            throw new InsufficientFundsException();
        }

        loan.acceptMonthlyPayment();

        // deduct from wallet
        if (walletAmount > loanPayment) {
            subtractFromWallet(loanPayment);
        } else {
            double paidSoFar = walletAmount;
            double toPay = loanPayment - paidSoFar;
            subtractFromWallet(walletAmount);

            // deduct from checking
            if (account.containsKey("Checking")) {
                if (account.get("Checking").getBalance() > toPay) {
                    account.get("Checking").setBalance(account.get("Checking").getBalance() - toPay);
                } else {

                    // deduct from saving (Emptied checking)
                    paidSoFar += account.get("Checking").getBalance();
                    toPay = loanPayment - paidSoFar;
                    account.get("Checking").setBalance(0);
                    account.get("Saving").setBalance(account.get("Saving").getBalance() - toPay);
                }
            } else {
                // deduct from saving (No checking)
                account.get("Saving").setBalance(account.get("Saving").getBalance() - toPay);
            }
        }

    }

    private double netWorthWithoutSecurity() {
        double accumulator = this.walletAmount;
        if(AccountAlreadyExisted("Checking")) {
            accumulator += this.account.get("Checking").getBalance();
        }
        if(AccountAlreadyExisted("Saving")) {
            accumulator += this.account.get("Saving").getBalance();
        }
        return accumulator;
    }
    
    public void SavingtransferToSecurity(double amount) throws Exception{
    	Account saving = this.account.get("Saving");
    	Account security = this.account.get("Security");
		if(amount + saving.getTransactionFee() > saving.getBalance()){
            throw new InsufficientFundsException();
        }else if (amount < 1000) {
        	throw new InvalidAmountException();
        }else{
        	saving.setBalance(saving.getBalance()-amount-saving.getTransactionFee());
        	security.setBalance(security.getBalance()+amount);
        }
	}


    @Override
    public String toString(){
        return "\nCustomer Information\n" +
                "First Name: " + getFirstName() + "\n" +
                "Last Name: " + getLastName() +  "\n" +
                "SSN: " + getSsn() +  "\n" +
                "Cash in hand: " + getWalletAmount() + "\n" +
                "Credit Score: " + getCreditScore() + "\n" +
                "Authorization: " + getAuthorization();
    }

}
