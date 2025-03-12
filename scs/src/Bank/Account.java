package Bank;

public abstract class Account {
    private static int counter_ = 0;

    private final int id_;
    protected double balance_;

    public Account(double balance) {
        this.id_ = counter_++;
        this.balance_ = balance;
    }

    public abstract void takeMoney(double amount);
    public abstract boolean checkTransactionValidity(double amount);

    public int getId() {
        return this.id_;
    }

    public double getBalance() {
        return this.balance_;
    }
}
