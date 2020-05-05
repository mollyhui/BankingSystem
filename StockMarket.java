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
	
	
//	public Hashtable<String, Stock> addStocks() {
//		Stock amazon = new Stock("Amazon", 20); 
//        Stock facebook = new Stock("Facebook", 30); 
//        Stock microsoft = new Stock("Microsoft", 40); 
//        Stock google = new Stock("Google", 50); 
//        
//
//        this.stocks.put("amazon", amazon); 
//        this.stocks.put("facebook",facebook); 
//        this.stocks.put("microsoft",microsoft); 
//        this.stocks.put("google",google); 
//		
////		this.stocks = Arrays.asList(
////			    Arrays.asList("Amazon", "20", "100"),
////			    Arrays.asList("Facebook", "30", "200"),
////			    Arrays.asList("Microsoft", "40", "150"),
////			    Arrays.asList("Google", "50", "150")
////			);
//        
//
//        return stocks; 
//	}
}
