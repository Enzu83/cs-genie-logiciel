package Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank bank_;
    private CreditAccount creditAccount_;
    private DebitAccount debitAccount_;

    @BeforeEach
    void setUp() {
        this.bank_ = new Bank();
        this.bank_.addCreditAccount(100.0, 50.0);
        this.bank_.addDebitAccount(50.0);
        this.creditAccount_ = (CreditAccount) this.bank_.getAccount(0);
        this.debitAccount_ = (DebitAccount) this.bank_.getAccount(1);
    }

    @Test
    void checkTransactionValidityIncorrectId() {
        assertFalse(this.bank_.checkTransactionValidity(2, 100.0)); // Account id not corresponding to any
    }

    @Test
    void checkTransactionValidityCreditAccount() {
        assertFalse(bank_.checkTransactionValidity(this.creditAccount_.getId(), 100.0)); // Not enough debt left
        assertTrue(bank_.checkTransactionValidity(this.creditAccount_.getId(), 50.0)); // Enough debt left
    }

    @Test
    void checkTransactionValidityDebitAccount() {
        assertFalse(bank_.checkTransactionValidity(this.debitAccount_.getId(), 100.0)); // Not enough balance
        assertTrue(bank_.checkTransactionValidity(this.debitAccount_.getId(), 50.0)); // Enough balance
    }

    @Test
    void performTransactionCreditAccount() {
        this.bank_.performTransaction(this.creditAccount_.getId(), 100.0); // Not enough debt left
        assertEquals(0.0, this.creditAccount_.getCurrentDebt());

        this.bank_.performTransaction(this.creditAccount_.getId(), 30.0); // Enough debt left
        assertEquals(30.0, this.creditAccount_.getCurrentDebt());
    }

    @Test
    void performTransactionDebitAccount() {
        this.bank_.performTransaction(this.debitAccount_.getId(), 150.0); // Not enough balance
        assertEquals(50.0, this.debitAccount_.getBalance());

        this.bank_.performTransaction(this.debitAccount_.getId(), 30.0); // Enough balance
        assertEquals(20.0, this.debitAccount_.getBalance());
    }
}