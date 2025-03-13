package Bank;

public class CreditAccount extends Account {
    private double maxDebt_;
    private double currentDebt_ = 0;

    public CreditAccount(double balance, double maxDebt) {
        super(balance);

        this.maxDebt_ = maxDebt;
    }

    public void takeMoney(double amount) {
        if (checkTransactionValidity(amount)) {
            this.currentDebt_ += amount;
        }
        else {
            System.out.println("Insufficient debt left (" + (this.maxDebt_ - this.currentDebt_) + ") to add " + amount + ".");
        }
    }

    public boolean checkTransactionValidity(double amount) {
        return this.currentDebt_ + amount <= this.maxDebt_;
    }

    public void setMaxDebt(double maxDebt) {
        this.maxDebt_ = maxDebt;
    }

    public double getMaxDebt() {
        return this.maxDebt_;
    }

    public double getCurrentDebt() {
        return this.currentDebt_;
    }

    public String toString() {
        return "CreditAccount[id=" + this.id_ + ", balance=" + this.balance_ + ", maxDebt=" + this.maxDebt_ + "]";
    }
}
