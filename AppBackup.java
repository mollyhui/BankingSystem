import java.io.*;
import java.util.ArrayList;

public class AppBackup {

    public static void main(String[] args) throws IOException, Exception {
        if (args[0].equals("a")) {
            System.out.println(authenticateUser("customer", "123456789", "pw123"));
            System.out.println(authenticateUser("manager", "45678765", "3999"));
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
            deleteUserFromFile("5", "customer");
            deleteUserFromFile("5", "manager");
        } else if (args[0].equals("g")) {
            addCheckingsAccount("45676543457", "56785678", 556.26, 2.75);
        } else if (args[0].equals("h")) {
            addSavingsAccount("45676543457", "56785678", 1987, 2.45, 1.9);
        } else if (args[0].equals("i")) {
            addSecurityAccount("45676543457", "56785678", 1000, 9.9);
        } else if (args[0].equals("j")) {
            System.out.println(getUserAttribute("45676543457", "customer", 4));
            System.out.println(getUserAttribute("6", "manager", 1));
        }



    }
    // CUSTOMER
    //
    // [0]SSN, [1]password, [2]name, [3]C-AccNumber, [4]C-Balance, [5]C-transFee, [6]Sav-AccNumber, [7]Sav-Balance,
    // [8]Sav-transFee, [9]Sav-Interest, [10]Sec-AccNumber, [11]Sec-Balance, [12]Sec-transFee, [13]Loan-amount, [14]Loan-term,
    // [15]Loan-Interest, [16]Loan-UnpaidMonths
    //
    // MANAGER
    //
    // [0]SSN, [1]password, [2]name, [3]balance

    /**
     * methods to have:
     *  NOT NEEDED create CSV files - blank files will be provided (customerData.txt, managerData.txt)
     *
     *  DONE GET Method for all attributes given SSN (customer and manager)
     *  update Method for all attributes given SSN (customer and manager)
     *  DONE createCustomer
     *  DONE createManager
     *  DONE authenticate customer
     *  DONE authenticate manager
     *  DONE accountExists (Checking , Saving, Sec)
     *  DONE addAccount (Checking , Saving, Sec)
     *  DONE loanExists
     *  addLoan
     *  payLoan
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
            if (data[0].equals(ssn)) {
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
            if (data[0].equals(ssn)) {
                return true;
            }
        }
        return false;
    }


    public static void createCustomer(String ssn, String password, String name) throws Exception {
        if (userExists("customer", ssn)) {
            throw new Exception();
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
            throw new Exception();
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
            if (data[0].equals(ssn)) {
                switch (accountType) {
                    case "checkings": {
                        if (!data[4].equals("null")) {
                            accountExists = true;
                        }
                        break;
                    }
                    case "savings": {
                        if (!data[7].equals("null")) {
                            accountExists = true;
                        }
                        break;
                    }
                    case "security": {
                        if (!data[11].equals("null")) {
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
            if (data[0].equals(ssn)) {
                if (!data[14].equals("null")) {
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
        String[] userData = new String[17]; // prepare original user data

        BufferedReader csvReader = new BufferedReader(new FileReader("customerData.txt"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[0].equals(ssn)) {
                userData = data;
            }
        }
        // now we have the original user data
        // now update the data to include checkings account info
        userData[3] = accountNumber;
        userData[4] = Double.toString(startingBalance);
        userData[5] = Double.toString(transactionFee);
        //System.out.println(userData[4]);

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
        String[] userData = new String[17]; // prepare original user data

        BufferedReader csvReader = new BufferedReader(new FileReader("customerData.txt"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[0].equals(ssn)) {
                userData = data;
            }
        }
        // now we have the original user data
        // now update the data to include savings account info
        userData[6] = accountNumber;
        userData[7] = Double.toString(startingBalance);
        userData[8] = Double.toString(transactionFee);
        userData[9] = Double.toString(interest);

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
        String[] userData = new String[17]; // prepare original user data

        BufferedReader csvReader = new BufferedReader(new FileReader("customerData.txt"));
        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            if (data[0].equals(ssn)) {
                userData = data;
            }
        }
        // now we have the original user data
        // now update the data to include security account info
        userData[10] = accountNumber;
        userData[11] = Double.toString(startingBalance);
        userData[12] = Double.toString(transactionFee);

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
            if (! data[0].equals(ssn)) {
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
