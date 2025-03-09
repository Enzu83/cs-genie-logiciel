public class CreditAccount extends Account {
    private double maxDebt_;
    private double currentDebt_;

    public CreditAccount(double balance, double maxDebt) {
        super(balance);

        this.maxDebt_ = maxDebt;
        this.currentDebt_ = 0;
    }

    public void takeMoney(double amount) {
        if (checkTransactionValidity(amount)) {
            this.currentDebt_ += amount;
        }
        else {
            System.out.println("Insufficient debt left (" + this.currentDebt_ + ") to add " + amount + ".");
        }
    }

    public boolean checkTransactionValidity(double amount) {
        return this.currentDebt_ + amount <= this.maxDebt_;
    }

    private void setMaxDebt(double maxDebt) {
        this.maxDebt_ = maxDebt;
    }

    private double getMaxDebt() {
        return this.maxDebt_;
    }

    private double getCurrentDebt() {
        return this.currentDebt_;
    }
}
