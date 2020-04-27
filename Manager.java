import java.io.Serializable;

public class Manager extends User implements Serializable {

    Manager(String firstName, String lastName, String ssn, String password) {
        super(firstName, lastName, ssn, password);
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
