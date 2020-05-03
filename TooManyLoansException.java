public class TooManyLoansException extends Exception {

    public TooManyLoansException() {
        super("Too many loans are being created for this customer.");
    }

}