public class Loan {
    private double amount;
    private double unpaidAmount;
    private int term_months;
    private int unpaidMonths;
    private double interest_rate;
    private double monthly_payment;

    Loan(double amount, int term_months, double interest_rate) {
        this.amount = amount;
        this.unpaidAmount = amount;
        this.term_months = term_months;
        this.unpaidMonths = term_months;
        this.interest_rate = interest_rate;
        this.monthly_payment = this.calculate_monthly_payment();
    }

    public double calculate_monthly_payment() {
        double interest = amount * interest_rate/100 * term_months/12;
        double total_owed = amount + interest;
        return total_owed/term_months;
    }

    public double getMonthlyPayment() {
        return monthly_payment;
    }

    public void acceptMonthlyPayment() {
        this.unpaidMonths -= 1;
        this.unpaidAmount -= this.monthly_payment;
    }
}
