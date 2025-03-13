package Bank;

public class DebitAccount extends Account {

    public DebitAccount(double balance) {
        super(balance);
    }

    public void takeMoney(double amount) { this.balance_ -= amount; }

    public boolean checkTransactionValidity(double amount) {
        if (this.balance_ >= amount) {
            return true;
        }
        else {
            System.out.println("[DebitAccount]: Insufficient balance (" + this.balance_ + ") to take " + amount + ".");
            return false;
        }
    }

    public String toString() {
        return "DebitAccount[id=" + this.id_ + ", balance=" + this.balance_ + "]";
    }
}
