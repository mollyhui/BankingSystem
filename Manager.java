import java.io.Serializable;

public class Manager extends User implements Serializable {

    Manager(String name, String ssn, String password) {
        super(name, ssn, password);
    }

    public String getAuthorization() {
        return "admin";
    }

    @Override
    public String toString() {
        return "\nManager Information\n" +
                "First Name: " + getName() + "\n" +
                "SSN: " + getSsn() +  "\n" +
                "Authorization: " + getAuthorization();
    }
}
