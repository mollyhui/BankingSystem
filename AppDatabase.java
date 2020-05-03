import java.sql.*;

public class AppDatabase {
    public static void main (String[] args) {
        try {
            // connection
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankDB?serverTimezone=UTC", "root", "591Nelson");
            // create statement
            Statement statement = myConn.createStatement();
            // execute
            ResultSet resultSet = statement.executeQuery("select * from customers");
            // process result set
            while (resultSet.next()) {
                System.out.println(34);
                System.out.println(resultSet.getString("fName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(3);

    }
}
