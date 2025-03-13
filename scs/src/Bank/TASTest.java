package Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TASTest {
    private CreditAccount creditAccount_;
    private DebitAccount debitAccount_;
    private TAS tas_;

    @BeforeEach
    void setUp() {
        Bank bank_ = new Bank();
        bank_.addCreditAccount(100.0, 50.0);
        bank_.addDebitAccount(50.0);
        this.creditAccount_ = (CreditAccount) bank_.getAccount(0);
        this.debitAccount_ = (DebitAccount) bank_.getAccount(1);
        this.tas_ = new TAS(bank_);
    }

    @Test
    void openSecureConnection() {
        assertTrue(this.tas_.openSecureConnection());
    }

    @Test
    void startTransactionCreditAccount() {
        assertFalse(this.tas_.startTransaction(this.creditAccount_.getId(), 100.0)); // Can't start and perform transaction
        assertEquals(0.0, this.creditAccount_.getCurrentDebt());

        assertTrue(this.tas_.startTransaction(this.creditAccount_.getId(), 30.0)); // Can start and perform transaction
        assertEquals(30.0, this.creditAccount_.getCurrentDebt());
    }

    @Test
    void startTransactionDebitAccount() {
        assertFalse(this.tas_.startTransaction(this.debitAccount_.getId(), 100.0)); // Can't start and perform transaction
        assertEquals(50, this.debitAccount_.getBalance());

        assertTrue(this.tas_.startTransaction(this.debitAccount_.getId(), 30.0)); // Can start and perform transaction
        assertEquals(20.0, this.debitAccount_.getBalance());
    }
}