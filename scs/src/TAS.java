public class TAS {
    private Bank bank_;

    public TAS(Bank bank) {
        this.bank_ = bank;
    }

    public void openSecureConnection() {
        System.out.println("Secure connection opened.");
    }

    public void closeSecureConnection() {
        System.out.println("Secure connection closed.");
    }

    public boolean startTransaction(int accountId, double amount) {
        if (!bank_.checkTransactionValidity(accountId, amount)) {
            System.out.println("Transaction not valid.");
            return false;
        }
        else {
            bank_.performTransaction(accountId, amount);
            System.out.println("Transaction done.");
            return true;
        }
    }

    public void setBank(Bank bank_) {
        this.bank_ = bank_;
    }

    public Bank getBank() {
        return this.bank_;
    }
}
