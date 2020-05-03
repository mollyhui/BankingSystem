public class User {

    private final String name;
    private final String ssn;
    private String password;

    public User(String name, String ssn, String password) {
        this.name=name;
        this.ssn = ssn;
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getSsn() {
        return ssn;
    }

    public boolean correctPassword(String attempt) {
        return this.password.equals(attempt);
    }
}
