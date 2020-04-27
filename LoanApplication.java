public class LoanApplication {
    private Customer customer;
    private double amount;
    private int term_months;

    LoanApplication(Customer customer, double loanRequest, int term_months) {
        this.customer = customer;
        this.amount = loanRequest;
        this.term_months = term_months;
    }

    public boolean qualify() {
        return amount < 1250 * customer.getCreditScore();
    }

}
