import java.io.Serializable;
import java.sql.SQLException;

public class Manager extends User implements Serializable {

    Manager(String firstName, String lastName, String ssn, String password) throws SQLException {
        super(firstName, lastName, ssn, password);
        AppDatabase.createManager(ssn, password, firstName, lastName);
    }

    public String getAuthorization() {
        return "admin";
    }

    @Override
    public String toString() {
        return "\nManager Information\n" +
                "First Name: " + getFirstName() + "\n" +
                "Last Name: " + getLastName() +  "\n" +
                "SSN: " + getSsn() +  "\n" +
                "Authorization: " + getAuthorization();
    }
}
