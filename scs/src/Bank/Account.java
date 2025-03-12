package Bank;

import java.util.Random;

public abstract class Account {
    private static int counter_ = 0;
    private static Random random_ = new Random();

    protected final int id_;
    protected double balance_;

    public Account(double balance) {
        this.id_ = counter_++;
        this.balance_ = balance;
    }

    public abstract void takeMoney(double amount);
    public abstract boolean checkTransactionValidity(double amount);

    public Card createCard() {
        int pin = random_.nextInt() % 10000;
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            number.append((char) random_.nextInt() % 10);
        }

        return new Card(this.id_, pin, number.toString());
    }

    public int getId() {
        return this.id_;
    }

    public double getBalance() {
        return this.balance_;
    }

    public abstract String toString();
}
