public class User {

    private final String firstName;
    private final String lastName;
    private final String ssn;
    private String password;

    public User(String firstName, String lastName, String ssn, String password) {
        this.firstName= firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public boolean correctPassword(String attempt) {
        return this.password.equals(attempt);
    }
}
