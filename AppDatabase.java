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

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankDB?serverTimezone=UTC", "root", "591Nelson");
        PreparedStatement customerStatement = connection.prepareStatement(
                "CREATE TABLE BankDB.customers ( SSN char(9), password varchar(45), fName varchar(45), lName varchar(45), walletAmount double , creditScore int)");
        customerStatement.executeUpdate();
        PreparedStatement managerStatement = connection.prepareStatement(
                "CREATE TABLE BankDB.managers ( SSN char(9), password varchar(45), fName varchar(45), lName varchar(45))");
        managerStatement.executeUpdate();

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


    public static void updateCustomer(String ssn, String column, double newValue) throws SQLException {
        if (!initialized) {
            initialize();
        }

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankDB?serverTimezone=UTC", "root", "591Nelson");
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE customers SET " + "? = ? WHERE SSN = ?");
        statement.setString(1, column);
        statement.setDouble(2, newValue);
        statement.setString(3, ssn);
        statement.executeUpdate();
    }
// process result set
    //while (resultSet.next()) {
    //System.out.println(34);
    //System.out.println(resultSet.getString("fName"));

}

