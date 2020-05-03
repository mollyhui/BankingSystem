public class ClassTester {
    public static void main (String [] args) throws Exception {
        Customer nelson = new Customer("Nelson", "Mei", "123456789", "1234", 1000, 800);
        nelson.addBankAccount("Checking", new Checking(1000));
        nelson.addBankAccount("Saving", new Saving(7000));
        nelson.addBankAccount("Security", new SecurityAccount(0));
        
//        System.out.println("Original security account: " + "\n" + nelson.getAccount("Security"));
//        System.out.println("Original saving account: " + "\n" + nelson.getAccount("Saving"));
//        SecurityAccount security = (SecurityAccount) nelson.getAccount("Security");
//        Saving saving = (Saving) nelson.getAccount("Saving");
//        saving.transfer(security, 1000);
//        System.out.println("New security account: " + "\n" + nelson.getAccount("Security"));
//        System.out.println("New saving account: " + "\n" + nelson.getAccount("Saving"));
//        
        
        Manager amber = new Manager("Amber", "Sun", "999999999", "7890");
        LoanApplication application = new LoanApplication(nelson, 800000, 36);

        System.out.println(nelson);
        System.out.println(nelson.getAccount("Checking"));
        System.out.println(nelson.getAccount("Saving"));
        System.out.println(nelson.getAccount("Security"));
        System.out.println(amber);
        System.out.println(application.qualify());
        Loan loan = new Loan(800000, 36, 5);
        System.out.println(loan.getMonthlyPayment());
    }
}
