package BackEnd;
public class InvalidAccountException extends Exception {

    public InvalidAccountException() {
        super("Account already existed.");
    }

}
