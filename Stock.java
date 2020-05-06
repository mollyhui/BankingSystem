public class Stock {
	private String company_name;
	private double price;
	//private int shares;
	
	
	public Stock(String company_name, double price) {
		this.company_name = company_name;
		this.price = price;
	}
	
	public String getName() {
		return this.company_name;
	}
	
	public double getPrice() {
		return this.price;
	}
	

	
	
//	public int getShares() {
//		return this.shares;
//	}
	
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return getName()+","+getPrice();
                
                
	}
	
	
	
}
