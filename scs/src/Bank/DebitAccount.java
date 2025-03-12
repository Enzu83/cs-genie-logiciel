package Bank;

public class DebitAccount extends Account {

    public DebitAccount(double balance) {
        super(balance);
    }

    public void takeMoney(double amount) {
        if (checkTransactionValidity(amount)) {
            this.balance_ -= amount;
        }
        else {
            System.out.println("Insufficient balance (" + this.balance_ + ") to take " + amount + ".");
        }
    }

    public boolean checkTransactionValidity(double amount) {
        return this.balance_ >= amount;
    }

    public String toString() {
        return "DebitAccount[id=" + this.id_ + ", balance=" + this.balance_ + "]";
    }
}
