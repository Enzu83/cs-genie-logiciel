package Bank;

public class CreditAccount extends Account {
    private double maxDebt_;
    private double currentDebt_ = 0;

    public CreditAccount(double balance, double maxDebt) {
        super(balance);

        this.maxDebt_ = maxDebt;
    }

    public void takeMoney(double amount) { this.currentDebt_ += amount; }

    public boolean checkTransactionValidity(double amount) {
        if (this.currentDebt_ + amount <= this.maxDebt_) {
            return true;
        }
        else {
            System.out.println("[CreditAccount]: Insufficient debt left (" + (this.maxDebt_ - this.currentDebt_) + ") to add " + amount + ".");
            return false;
        }
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
