import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;


public class Customer extends User implements Serializable{
    private double walletAmount;
    private int creditScore;
    private Loan loan = null;
    
    private Hashtable<String, Account> account = new Hashtable<String, Account>();
    // Savings Account field
    // Checkings Account field
    // Securities Account field


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
    	switch(type) {
    	case "Checking":
    		if (!checkExistingAccount(type)) this.account.put(type, account);
    		else throw new InvalidAccountException();
    		break;
    	case "Saving":
    		if (!checkExistingAccount(type)) this.account.put(type, account);
    		else throw new InvalidAccountException();
    		break;
    	case "Security":
    		if (!checkExistingAccount(type)) this.account.put(type, account);
    		else throw new InvalidAccountException();
    		break;
    	default:
    		System.out.println("Invalid account type.");
    		break;
    	}
    }
    public boolean checkExistingAccount(String type){
    	boolean existed = false;
    	if (account.containsKey("type")) {
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

    public void addLoan(Loan loan) throws Exception{
        if (this.loan != null) {
            throw new Exception();
        }

        this.loan = loan;
    }

    public void makeLoanPayment() throws InsufficientFundsException{
        // take from savings, or from checkings first
        if (this.walletAmount < this.loan.getMonthlyPayment()){
            throw new InsufficientFundsException();
        }

        this.loan.acceptMonthlyPayment();
        this.walletAmount -= this.loan.getMonthlyPayment();
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
