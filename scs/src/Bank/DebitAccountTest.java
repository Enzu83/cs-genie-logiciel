package Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebitAccountTest {
    private DebitAccount debitAccount_;

    @BeforeEach
    void setUp() {
        this.debitAccount_ = new DebitAccount(100.0);
    }

    @Test
    void createCard() {
        Card card = this.debitAccount_.createCard();
        assertEquals(this.debitAccount_.getId(), card.getAccountId()); // Verify that the ids match
    }

    @Test
    void checkTransactionValidity() {
        assertFalse(this.debitAccount_.checkTransactionValidity(150.0)); // Not enough balance
        assertTrue(this.debitAccount_.checkTransactionValidity(50.0)); // Enough balance
    }

    @Test
    void takeMoney() {
        this.debitAccount_.takeMoney(150.0); // Too much money to be taken. Balance not updated
        assertEquals(100.0, this.debitAccount_.getBalance());

        this.debitAccount_.takeMoney(40.0); // Remove 40.0 from the balance
        assertEquals(60.0, this.debitAccount_.getBalance());
    }
}