package Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class POSTest {
    private CreditAccount creditAccount_;
    private DebitAccount debitAccount_;

    private POS pos_;
    private Card card_;

    @BeforeEach
    void setUp() {
        Bank bank_ = new Bank();
        bank_.addCreditAccount(100.0, 50.0);
        bank_.addDebitAccount(50.0);
        this.creditAccount_ = (CreditAccount) bank_.getAccount(0);
        this.debitAccount_ = (DebitAccount) bank_.getAccount(1);
        TAS tas_ = new TAS(bank_);

        this.pos_ = new POS(tas_);
        this.card_ = new Card(0, 1234, "1234567890123456");
    }

    @Test
    void insertCard() {
        assertNull(this.pos_.getInsertCard()); // No inserted card

        this.pos_.insertCard(this.card_);
        assertEquals(this.card_, this.pos_.getInsertCard()); // A card is inserted
    }

    @Test
    void ejectCardNoCard() {
        assertNull(this.pos_.getInsertCard());
    }

    @Test
    void ejectCardInsertAndEject() {
        this.pos_.insertCard(this.card_);
        this.pos_.ejectCard();
        assertNull(this.pos_.getInsertCard());
    }

    @Test
    void checkCard() {
        assertFalse(this.pos_.checkCard(null));
        assertTrue(this.pos_.checkCard(this.card_));
    }

    @Test
    void checkPIN() {
        assertFalse(this.pos_.checkPIN(4376)); // Can't check PIN if there is no inserted card

        this.pos_.insertCard(this.card_);
        assertFalse(this.pos_.checkPIN(4376)); // Wrong PIN
        assertTrue(this.pos_.checkPIN(1234)); // Correct PIN
    }

    @Test
    void askAuthorization() {
        assertTrue(this.pos_.askAuthorization()); // Authorization is always granted
    }

    @Test
    void startTransactionCreditAccount() {
        assertFalse(this.pos_.startTransaction(100.0)); // Can't start and perform transaction due to no inserted card
        assertEquals(0.0, this.creditAccount_.getCurrentDebt());

        Card creditCard = this.creditAccount_.createCard();

        this.pos_.insertCard(creditCard);
        assertFalse(this.pos_.startTransaction(100.0)); // Can't start and perform transaction due to amount
        assertEquals(0.0, this.creditAccount_.getCurrentDebt());

        assertTrue(this.pos_.startTransaction(30.0)); // Can start and perform transaction
        assertEquals(30.0, this.creditAccount_.getCurrentDebt());
    }

    @Test
    void startTransactionDebitAccount() {
        assertFalse(this.pos_.startTransaction(100.0)); // Can't start and perform transaction due to inserted card
        assertEquals(50, this.debitAccount_.getBalance());

        Card debitCard = this.debitAccount_.createCard();

        this.pos_.insertCard(debitCard);
        assertFalse(this.pos_.startTransaction(100.0)); // Can't start and perform transaction due to amount
        assertEquals(50, this.debitAccount_.getBalance());

        assertTrue(this.pos_.startTransaction(30.0)); // Can start and perform transaction
        assertEquals(20.0, this.debitAccount_.getBalance());
    }
}