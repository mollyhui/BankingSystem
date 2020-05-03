import java.io.*;

public class AppBackup {

    public static void main(String[] args) throws IOException, Exception {
        if (args[0].equals("a")) {
            System.out.println(authenticateUser("customer", "123456789", "pw123"));
            System.out.println(authenticateUser("manager", "45678765", "3999"));
        } else if (args[0].equals("b")) {
            createCustomer("45676543456", "pw6969", "SammyTo", 799);
        } else if (args[0].equals("c")) {
            createManager("92284732", "pwokok", "NelsonBobby");
        } else if (args[0].equals("d")) {
            System.out.println(customerAccountExists("45676543456", "checkings"));
            System.out.println(customerAccountExists("45676543456", "savings"));
            System.out.println(customerAccountExists("45676543456", "security"));
        } else if (args[0].equals("e")) {
            System.out.println(customerLoanExists("45676543456"));
        }
    }
    // csv file Customer column structure:
    // SSN, password, name, credit score, C-AccNumber, C-Balance, C-transFee, Sav-AccNumber, Sav-Balance, Sav-transFee, Sav-Interest, Sec-AccNumber, Sec-Balance, Sec-transFee, Loan-amount, Loan-term, Loan-Interest, Loan-UnpaidMonths
    //
    // csv file Manager column structure:
    // SSN, password, name, balance

    /**
     * methods to have:
     *  X create CSV files - called in GUI code?
     *  X delete CSV files
     *
     *  get Method for all attributes given SSN (customer and manager)
     *  mutate Method for all attributes given SSN (customer and manager)
     *  DONE createCustomer
     *  DONE createManager
     *  DONE authenticate customer
     *  DONE authenticate manager
     *  DONE accountExists (Checking , Saving, Sec)
     *  addAccount (Checking , Saving, Sec)
     *  DONE loanExists
     *  addLoan
     *  payLoan
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

    public static void createCustomer(String ssn, String password, String name, int creditScore) throws Exception {
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
            csvWriter.append(Integer.toString(creditScore));
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

    public static void createManager(String ssn, String password, String name) throws Exception {
        if (userExists("manager", ssn)) {
            throw new Exception();
        } else {
            FileWriter csvWriter = new FileWriter("managerData.txt", true);
            csvWriter.append(ssn);
            csvWriter.append(",");
            csvWriter.append(password);
            csvWriter.append(",");
            csvWriter.append(name);
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

}
