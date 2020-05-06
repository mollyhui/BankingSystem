package BackEnd;
public class ClassTester {
    public static void main (String [] args) throws Exception {
        Customer nelson = new Customer("Nelson", "Mei", "123456789", "1234", 1000, 800);
        nelson.addBankAccount("Checking", new Checking(1000));
        nelson.addBankAccount("Saving", new Saving(7000));
        nelson.addBankAccount("Security", new SecurityAccount(1110));
        
//        System.out.println("Original security account: " + "\n" + nelson.getAccount("Security"));
//        System.out.println("Original saving account: " + "\n" + nelson.getAccount("Saving"));
//        SecurityAccount security = (SecurityAccount) nelson.getAccount("Security");
//        Saving saving = (Saving) nelson.getAccount("Saving");
//        saving.transfer(security, 1000);
//        System.out.println("New security account: " + "\n" + nelson.getAccount("Security"));
//        System.out.println("New saving account: " + "\n" + nelson.getAccount("Saving"));
//        
//	      System.out.println("Original Saving account: " + "\n" + nelson.getAccount("Saving"));
//	      System.out.println("Original Checking account: " + "\n" + nelson.getAccount("Checking"));
//	      Saving saving = (Saving) nelson.getAccount("Saving");
//	      Checking checking = (Checking) nelson.getAccount("Checking");
//	      saving.transfer(checking, 1000);
//	      System.out.println("New Saving account: " + "\n" + nelson.getAccount("Saving"));
//	      System.out.println("New Checking account: " + "\n" + nelson.getAccount("Checking"));

//        System.out.println("Original Security account: " + "\n" + nelson.getAccount("Security"));
//        SecurityAccount security = (SecurityAccount) nelson.getAccount("security");
//        security.buyStock(new Stock("Amazon", 20,100), 20);
//	    System.out.println("New Security account: " + "\n" + nelson.getAccount("Security"));
	      
        Manager amber = new Manager("Amber", "Sun", "999999999", "7890");
        LoanApplication application = new LoanApplication(nelson, 800000, 36);

        //test manager set stock price 
        System.out.println("before set stock price: "+amber.getStockMarket().getStocks().get("Amazon").getPrice());
        amber.getStockMarket().setStockPrice("Amazon",100);
        System.out.println("after set stock price: "+amber.getStockMarket().getStocks().get("Amazon").getPrice());
        
        //test managet delete stock
        System.out.println("before delete stock: "+amber.getStockMarket().getStocks().values().toString());

        amber.getStockMarket().deleteStock("Amazon");
        System.out.println("after delete stock: "+amber.getStockMarket().getStocks().values().toString());
        
        //test customer buy stock
        System.out.println("Before buying stock, balance is: "+ nelson.getAccount("Security").getBalance());
        nelson.buyStock("Amazon",2);
        System.out.println("After buying stock, balance is: "+ nelson.getAccount("Security").getBalance());
        System.out.println(nelson.getStocks().values().toString());
        
        //test customer sell stock
        System.out.println("Before selling stock, balance is: "+ nelson.getAccount("Security").getBalance());
        nelson.sellStock("Amazon",2);
        System.out.println("After selling stock, balance is: "+ nelson.getAccount("Security").getBalance());
        System.out.println(nelson.getStocks().values().toString());
        
        //test customer sell stock
        
        System.out.println(nelson);
        System.out.println(nelson.getAccount("Checking"));
        System.out.println(nelson.getAccount("Saving"));
        System.out.println(nelson.getAccount("Security"));
        System.out.println(amber);
//        System.out.println(application.qualify());
//        Loan loan = new Loan(800000, 36, 5);
//        System.out.println(loan.getMonthlyPayment());
    }
}
