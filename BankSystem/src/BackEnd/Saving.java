package BackEnd;
public class Saving extends Account{
	private String accountType = "Saving";
	
	public Saving(double initialDeposit){
        this.setBalance(initialDeposit);
        this.setTransactionFee(10);
    }
	
	public String getAccountType() {
        return accountType;
    }
	
	public void setInterest(double amount) {
		if (this.getBalance() > 5000) {
			this.setInterest(0.02);
		}
	}
	
	public void transfer(Account account, double amount) throws Exception{
		if (account.getAccountType() == "Security") {
			if (this.getBalance() < 5000 || (amount + this.getTransactionFee() > this.getBalance())) {
				throw new InsufficientFundsException();
			}else if (amount < 1000) {
				throw new InvalidAmountException();
			}else if (this.getBalance()-amount-this.getTransactionFee() < 2500){
				throw new InsufficientFundsException();
			}
			else{
				this.setBalance(this.getBalance()-amount-this.getTransactionFee());
	        	account.setBalance(account.getBalance() + amount);
			}
		}else {
			if(amount + this.getTransactionFee() > this.getBalance()){
	            throw new InsufficientFundsException();
	        }else{
	        	this.setBalance(this.getBalance()-amount-this.getTransactionFee());
	        	account.setBalance(account.getBalance() + amount);
	        }
		}
	}
    
    @Override
    public String toString(){
        return "Account Type: " + accountType + " Account\n" +
                "Account Number: " + this.getAccountNumber() + "\n" +
                "Balance: " + this.getBalance() + "\n" + 
                "Interest Rate: " + (this.getInterest() * 100) + "%\n";
    }
}