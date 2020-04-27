public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("You have insufficient funds to pay your loan.");
    }

}