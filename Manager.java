import java.io.Serializable;

public class Manager extends User implements Serializable {
	private double balance;
	private StockMarket stockMarket = new StockMarket();

    Manager(String firstName, String lastName, String ssn, String password) {
        super(firstName, lastName, ssn, password);
    }
    
    public StockMarket getStockMarket() {
    	return this.stockMarket;
    }

    public String getAuthorization() {
        return "admin";
    }
    
    public double getBalance() {
    	return this.balance;
    }
    
    public void setBalance(double balance) {
    	this.balance = balance;
    }
    
    public void setStockPrice(String name, double price) {
    	this.stockMarket.getStocks().get(name).setPrice(price);
        //this.backup.updateCustomerStockAttribute(this.getSsn(),name,2,price);

    }
    
    public void deleteStock(String name) {
    	this.stockMarket.getStocks().remove(name);
    }
    

    @Override
    public String toString() {
        return "\nManager Information\n" +
                "First Name: " + getFirstName() + "\n" +
                "Last Name: " + getLastName() +  "\n" +
                "SSN: " + getSsn() +  "\n" +
                "Authorization: " + getAuthorization();
    }
}
