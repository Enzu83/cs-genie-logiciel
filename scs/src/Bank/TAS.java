package Bank;

public class TAS {
    private Bank bank_;

    public TAS(Bank bank) {
        this.bank_ = bank;
    }

    public boolean openSecureConnection() {
        System.out.println("[TAS]: Secure connection opened.");
        return true;
    }

    public void closeSecureConnection() {
        System.out.println("[TAS]: Secure connection closed.");
    }

    public boolean startTransaction(int accountId, double amount) {
        if (!bank_.checkTransactionValidity(accountId, amount)) {
            System.out.println("[TAS]: Transaction not valid.");
            return false;
        }
        else {
            bank_.performTransaction(accountId, amount);
            System.out.println("[TAS]: Transaction done.");
            return true;
        }
    }

    public void setBank(Bank bank_) {
        this.bank_ = bank_;
    }

    public Bank getBank() {
        return this.bank_;
    }

    public String toString() {
        return "TAS[Bank=" + this.bank_ + "]";
    }
}
