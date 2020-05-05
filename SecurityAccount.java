
public class SecurityAccount extends Account{
	private String accountType = "Security";
		
	SecurityAccount(double initialDeposit){
	        this.setBalance(initialDeposit);
	        this.setTransactionFee(10);
	    }
		
		public String getAccountType() {
	        return accountType;
	    }
		
	    
	    @Override
	    public String toString(){
	        return "Account Type: " + accountType + " Account\n" +
	                "Account Number: " + this.getAccountNumber() + "\n" +
	                "Balance: " + this.getBalance() + "\n" + 
	                "Interest Rate: " + (this.getInterest() * 100) + "%\n";
	    }
}
