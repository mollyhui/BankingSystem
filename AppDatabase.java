import java.sql.*;

public class AppDatabase {


    public static boolean initialized = false;
    public static void initialize() throws SQLException {
        initialized = true;
        initializeTables();
    }
    public static void initializeTables() throws SQLException {
        if (!initialized) {
            initialize();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankDB?serverTimezone=UTC", "root", "591Nelson");
            PreparedStatement customerStatement = connection.prepareStatement(
                    "CREATE TABLE BankDB.customers ( SSN char(9) PRIMARY KEY, password varchar(45), fName varchar(45), lName varchar(45), walletAmount double , creditScore int)");
            customerStatement.executeUpdate();
            PreparedStatement managerStatement = connection.prepareStatement(
                    "CREATE TABLE BankDB.managers ( SSN char(9) PRIMARY KEY, password varchar(45), fName varchar(45), lName varchar(45))");
            managerStatement.executeUpdate();
        } catch (SQLSyntaxErrorException e) {
            System.out.println("already initialized");
        }

    }

    public static void createCustomer(String ssn, String password, String fName, String lName, double walletAmount, int creditScore) throws SQLException {
        if (!initialized) {
            initialize();
        }

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankDB?serverTimezone=UTC", "root", "591Nelson");
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO customers Values('"+ssn +"', '"+password+"' , '"+fName+"' , '"+lName+"', '"+Double.toString(walletAmount)+
                        "', '"+Integer.toString(creditScore)+"')");
        statement.executeUpdate();
    }

    public static void createManager(String ssn, String password, String fName, String lName) throws SQLException {
        if (!initialized) {
            initialize();
        }

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankDB?serverTimezone=UTC", "root", "591Nelson");
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO managers(SSN, password, fName, lName) Values('"+ssn +"', '"+password+"' , '"+fName+"' , '"+lName+"')");
        statement.executeUpdate();
    }


    public static void updateCustomerWallet(String ssn, double newValue) throws SQLException {
        if (!initialized) {
            initialize();
        }

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankDB?serverTimezone=UTC", "root", "591Nelson");
        PreparedStatement statement;
        statement = connection.prepareStatement(
                "UPDATE customers SET walletAmount = ? WHERE SSN = ?");
        statement.setDouble(1, newValue);
        statement.setString(2, ssn);
        statement.executeUpdate();
    }
// process result set
    //while (resultSet.next()) {
    //System.out.println(34);
    //System.out.println(resultSet.getString("fName"));

}

