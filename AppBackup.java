import java.io.*;
import java.util.ArrayList;

public class AppBackup {

    static int numberOfCustomerColumns = 17;
    static int numberOfManagerColumns = 4;

    static int customerSSNIndex = 0;
    static int customerPasswordIndex = 1;
    static int customerNameIndex = 2;
    static int checkingsAccountNumberIndex = 3;
    static int checkingsBalanceIndex = 4;
    static int checkingsTransactionFeeIndex = 5;
    static int savingsAccountNumberIndex = 6;
    static int savingsBalanceIndex = 7;
    static int savingsTransactionFeeIndex = 8;
    static int savingsInterestIndex = 9;
    static int securityAccountNumberIndex = 10;
    static int securityBalanceIndex = 11;
    static int securityTransactionFeeIndex = 12;
    static int loanAmountIndex = 13;
    static int loanTermIndex = 14;
    static int loanInterestIndex = 15;
    static int loanUnpaidMonthsIndex = 16;

    static int managerSSNIndex = 0;
    static int managerPasswordIndex = 1;
    static int managerNameIndex = 2;
    static int managerBalanceIndex = 3;

    public static void main(String[] args) throws IOException, Exception {
        if (args[0].equals("a")) {
            System.out.println(authenticateUser("customer", "45676543458", "psw6969"));
            System.out.println(authenticateUser("manager", "6", "change"));
        } else if (args[0].equals("b")) {
            createCustomer("45676543456", "pw6969", "SammyTo");
            createCustomer("45676543457", "pw6969", "SammyTo2");
            createCustomer("45676543458", "pw6969", "SammyTo3");
        } else if (args[0].equals("c")) {
            createManager("92284732", "pwokok", "NelsonBobby", 10);
        } else if (args[0].equals("d")) {
            System.out.println(customerAccountExists("45676543456", "checkings"));
            System.out.println(customerAccountExists("45676543456", "savings"));
            System.out.println(customerAccountExists("45676543456", "security"));
        } else if (args[0].equals("e")) {
            System.out.println(customerLoanExists("45676543456"));
        } else if (args[0].equals("f")) {
            deleteUserFromFile("5", "manager");
        } else if (args[0].equals("g")) {
            addCheckingsAccount("45676543456", "56785678", 556.26, 2.75);
        } else if (args[0].equals("h")) {
            addSavingsAccount("45676543456", "56785678", 1987, 2.45, 1.9);
        } else if (args[0].equals("i")) {
            addSecurityAccount("45676543456", "56785678", 1000, 9.9);
        } else if (args[0].equals("j")) {
            System.out.println(getUserAttribute("45676543457", "customer", 4));
            System.out.println(getUserAttribute("6", "manager", 1));
        } else if (args[0].equals("k")) {
            updateUserAttribute("6", "manager", 1, "change1");
        } else if (args[0].equals("l")) {
            addLoan("45676543456", 299000, 12, 2.5, 12);
        }



    }

    /**
     * methods to have:
     *
     *  DONE GET Method for all attributes given SSN (customer and manager)
     *  DONE update Method for all attributes given SSN (customer and manager)
     *  DONE createCustomer
     *  DONE createManager
     *  DONE authenticate customer
     *  DONE authenticate manager
     *  DONE accountExists (Checking , Saving, Sec)
     *  DONE addAccount (Checking , Saving, Sec)
     *  DONE loanExists
     *  DONE addLoan
     *  DONE delete user from file
     *
     */

    public static boolean authenticateUser(String managerOrCustomer, String ssn, String attemptPassword) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("customerData.txt"));
        if (managerOrCustomer == "manager") {
            csvReader = new BufferedReader(new FileReader("managerData.txt"));
        }
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[customerSSNIndex].equals(ssn)) {
                if (data[1].equals(attemptPassword)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }


    public static boolean userExists(String managerOrCustomer, String ssn) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("customerData.txt"));
        if (managerOrCustomer == "manager") {
            csvReader = new BufferedReader(new FileReader("managerData.txt"));
        }
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[customerSSNIndex].equals(ssn)) {
                return true;
            }
        }
        return false;
    }


    public static void createCustomer(String ssn, String password, String name) throws Exception {
        if (userExists("customer", ssn)) {
            throw new Exception("user already exists");
        } else {
            FileWriter csvWriter = new FileWriter("customerData.txt", true);
            csvWriter.append(ssn);
            csvWriter.append(",");
            csvWriter.append(password);
            csvWriter.append(",");
            csvWriter.append(name);
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append(",");
            csvWriter.append("null");
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        }
    }


    public static void createManager(String ssn, String password, String name, double startingBalance) throws Exception {
        if (userExists("manager", ssn)) {
            throw new Exception("user already exists");
        } else {
            FileWriter csvWriter = new FileWriter("managerData.txt", true);
            csvWriter.append(ssn);
            csvWriter.append(",");
            csvWriter.append(password);
            csvWriter.append(",");
            csvWriter.append(name);
            csvWriter.append(",");
            csvWriter.append(Double.toString(startingBalance));
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        }
    }


    public static boolean customerAccountExists(String ssn, String accountType) throws IOException {
        boolean accountExists = false;

        BufferedReader csvReader = new BufferedReader(new FileReader("customerData.txt"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[customerSSNIndex].equals(ssn)) {
                switch (accountType) {
                    case "checkings": {
                        if (!data[checkingsAccountNumberIndex].equals("null")) {
                            accountExists = true;
                        }
                        break;
                    }
                    case "savings": {
                        if (!data[savingsAccountNumberIndex].equals("null")) {
                            accountExists = true;
                        }
                        break;
                    }
                    case "security": {
                        if (!data[securityAccountNumberIndex].equals("null")) {
                            accountExists = true;
                        }
                        break;
                    }
                }
            }
        }
        return accountExists;
    }


    public static boolean customerLoanExists(String ssn) throws IOException {
        boolean loanExists = false;

        BufferedReader csvReader = new BufferedReader(new FileReader("customerData.txt"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[customerSSNIndex].equals(ssn)) {
                if (!data[loanAmountIndex].equals("null")) {
                    loanExists = true;
                }
            }
        }
        return loanExists;
    }


    public static void addCheckingsAccount(String ssn, String accountNumber, double startingBalance, double transactionFee) throws Exception {
        if (!userExists("customer", ssn)) {
            throw new Exception("customer does not exist");
        }
        String[] userData = new String[numberOfCustomerColumns]; // prepare original user data

        BufferedReader csvReader = new BufferedReader(new FileReader("customerData.txt"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[customerSSNIndex].equals(ssn)) {
                userData = data;
            }
        }
        // now we have the original user data
        // now update the data to include checkings account info
        userData[checkingsAccountNumberIndex] = accountNumber;
        userData[checkingsBalanceIndex] = Double.toString(startingBalance);
        userData[checkingsTransactionFeeIndex] = Double.toString(transactionFee);

        deleteUserFromFile(ssn, "customer");
        FileWriter csvWriter = new FileWriter("customerData.txt", true);
        for (int i=0; i<userData.length; i++) {
            csvWriter.append(userData[i]);
            if (i != userData.length-1) {
                csvWriter.append(",");
            }
        }
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }


    public static void addSavingsAccount(String ssn, String accountNumber, double startingBalance, double transactionFee, double interest) throws Exception {
        if (!userExists("customer", ssn)) {
            throw new Exception("customer does not exist");
        }
        String[] userData = new String[numberOfCustomerColumns]; // prepare original user data

        BufferedReader csvReader = new BufferedReader(new FileReader("customerData.txt"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[customerSSNIndex].equals(ssn)) {
                userData = data;
            }
        }
        // now we have the original user data
        // now update the data to include savings account info
        userData[savingsAccountNumberIndex] = accountNumber;
        userData[savingsBalanceIndex] = Double.toString(startingBalance);
        userData[savingsTransactionFeeIndex] = Double.toString(transactionFee);
        userData[savingsInterestIndex] = Double.toString(interest);

        deleteUserFromFile(ssn, "customer");
        FileWriter csvWriter = new FileWriter("customerData.txt", true);
        for (int i=0; i<userData.length; i++) {
            csvWriter.append(userData[i]);
            if (i != userData.length-1) {
                csvWriter.append(",");
            }
        }
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }


    public static void addSecurityAccount(String ssn, String accountNumber, double startingBalance, double transactionFee) throws Exception {
        if (!userExists("customer", ssn)) {
            throw new Exception("customer does not exist");
        }
        String[] userData = new String[numberOfCustomerColumns]; // prepare original user data

        BufferedReader csvReader = new BufferedReader(new FileReader("customerData.txt"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[customerSSNIndex].equals(ssn)) {
                userData = data;
            }
        }
        // now we have the original user data
        // now update the data to include security account info
        userData[securityAccountNumberIndex] = accountNumber;
        userData[securityBalanceIndex] = Double.toString(startingBalance);
        userData[securityTransactionFeeIndex] = Double.toString(transactionFee);

        deleteUserFromFile(ssn, "customer");
        FileWriter csvWriter = new FileWriter("customerData.txt", true);
        for (int i=0; i<userData.length; i++) {
            csvWriter.append(userData[i]);
            if (i != userData.length-1) {
                csvWriter.append(",");
            }
        }
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }

    public static String getUserAttribute(String ssn, String managerOrCustomer, int indexOAttribute) throws Exception {
        if (!userExists("customer", ssn) && (!userExists("manager", ssn))) {
            throw new Exception("User does not exist");
        }

        BufferedReader csvReader;
        if (managerOrCustomer == "manager") {
            csvReader = new BufferedReader(new FileReader("managerData.txt"));
        } else {
            csvReader = new BufferedReader(new FileReader("customerData.txt"));
        }

        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[0].equals(ssn)) {
                return data[indexOAttribute];
            }
        }
        return "not found";
    }


    public static void updateUserAttribute(String ssn, String managerOrCustomer, int indexOAttribute, String newValue) throws Exception {
        if (!userExists("customer", ssn) && (!userExists("manager", ssn))) {
            throw new Exception("User does not exist");
        }

        String[] userData;
        if (managerOrCustomer.equals("customer")) {
            userData = new String[numberOfCustomerColumns]; // prepare original user data
        } else {
            userData = new String[numberOfManagerColumns];
        }

        BufferedReader csvReader;
        if (managerOrCustomer.equals("customer")) {
            csvReader = new BufferedReader(new FileReader("customerData.txt"));
        } else {
            csvReader = new BufferedReader(new FileReader("managerData.txt"));
        }

        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[managerOrCustomer.equals("customer") ? customerSSNIndex : managerSSNIndex].equals(ssn)) {
                userData = data;
            }
        }
        // now update the data to reflect new value
        userData[indexOAttribute] = newValue;

        if (managerOrCustomer.equals("customer")) {
            deleteUserFromFile(ssn, "customer");
        } else {
            deleteUserFromFile(ssn, "manager");
        }

        FileWriter csvWriter;
        if (managerOrCustomer.equals("customer")) {
            csvWriter = new FileWriter("customerData.txt", true);
        } else {
            csvWriter = new FileWriter("managerData.txt", true);
        }

        for (int i=0; i<userData.length; i++) {
            csvWriter.append(userData[i]);
            if (i != userData.length-1) {
                csvWriter.append(",");
            }
        }
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }


    public static void addLoan(String ssn, double amount, int term, double interest, int unpaidMonths) throws Exception {
        if (!userExists("customer", ssn)) {
            throw new Exception("customer does not exist");
        }
        String[] userData = new String[numberOfCustomerColumns]; // prepare original user data

        BufferedReader csvReader = new BufferedReader(new FileReader("customerData.txt"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[customerSSNIndex].equals(ssn)) {
                userData = data;
            }
        }
        // now we have the original user data
        // now update the data to include loan info
        userData[loanAmountIndex] = Double.toString(amount);
        userData[loanTermIndex] = Integer.toString(term);
        userData[loanInterestIndex] = Double.toString(interest);
        userData[loanUnpaidMonthsIndex] = Integer.toString(unpaidMonths);

        deleteUserFromFile(ssn, "customer");
        FileWriter csvWriter = new FileWriter("customerData.txt", true);
        for (int i=0; i<userData.length; i++) {
            csvWriter.append(userData[i]);
            if (i != userData.length-1) {
                csvWriter.append(",");
            }
        }
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
    }

    /**
     * helper method used for replacing row in txt file
     */
    public static void deleteUserFromFile(String ssn, String customerOrManager) throws IOException {
        ArrayList<String[]> putBack = new ArrayList<>(); // data not to be deleted

        BufferedReader csvReader;
        if (customerOrManager.equals("manager")) {
            csvReader = new BufferedReader(new FileReader("managerData.txt"));
        } else {
            csvReader = new BufferedReader(new FileReader("customerData.txt"));
        }
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (! data[customerOrManager.equals("customer") ? customerSSNIndex : managerSSNIndex].equals(ssn)) {
                putBack.add(data);
            }
        }
        // now we have all line we still want, now we clear the file and put stuff back in

        FileWriter csvWriter;
        if (customerOrManager.equals("manager")) {
            csvWriter = new FileWriter("managerData.txt", false);
        } else {
            csvWriter = new FileWriter("customerData.txt", false);
        }
        csvWriter.append("");

        for (String[] rowData: putBack) {
            for (int i=0; i<rowData.length; i++) {
                csvWriter.append(rowData[i]);
                if (i != rowData.length-1) {
                    csvWriter.append(",");
                }
            }
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();

    }

}
