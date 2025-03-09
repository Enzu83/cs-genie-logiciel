import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts_;

    public Bank() {
        this.accounts_ = new ArrayList<Account>();
    }

    public void newCreditAccount(double maxDebt) {
        this.accounts_.add(new CreditAccount(0., maxDebt));
    }

    public void newDebitAccount() {
        this.accounts_.add(new DebitAccount(0.));
    }

    private Account findAccount(int accountId) {
        for (Account account : this.accounts_) {
            if (account.getId_() == accountId) {
                return account;
            }
        }

        return null;
    }

    public boolean checkTransactionValidity(int accountId, double amount) {
        // Search for the corresponding account
        Account account = findAccount(accountId);

        if (account == null) {
            System.out.println("Account with id " + accountId + " not found. End transaction.");
            return false;
        }
        else {
            return account.checkTransactionValidity(amount);
        }
    }

    public void performTransaction(int accountId, double amount) {
        Account account = findAccount(accountId);

        if (account == null) {
            System.out.println("Account with id " + accountId + " not found. Can't perform transaction.");
        }
        else {
            account.takeMoney(amount);
        }
    }
}
