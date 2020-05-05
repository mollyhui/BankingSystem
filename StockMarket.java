import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class StockMarket {
	//private List<List<String>> stocks;
	private Hashtable<String, Stock> stocks = new Hashtable<String, Stock>();

	public StockMarket() {
		Stock amazon = new Stock("Amazon", 20); 
        Stock facebook = new Stock("Facebook", 30); 
        Stock microsoft = new Stock("Microsoft", 40); 
        Stock google = new Stock("Google", 50); 
       
        this.stocks.put("Amazon", amazon); 
        this.stocks.put("Facebook",facebook); 
        this.stocks.put("Microsoft",microsoft); 
        this.stocks.put("Google",google); 
	}

	
	public Hashtable<String, Stock> getStocks() {
		
        return this.stocks;
    }
	
	public void setStockPrice(String name, double price) {
		this.getStocks().get(name).setPrice(price);
	}
	
	public void deleteStock(String name) {
    	this.getStocks().remove(name);
    }
}
