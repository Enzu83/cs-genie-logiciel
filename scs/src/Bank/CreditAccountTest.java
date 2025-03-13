package Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {
    private CreditAccount creditAccount_;

    @BeforeEach
    void setUp() {
        this.creditAccount_ = new CreditAccount(100.0, 50.0);
    }

    @Test
    void createCard() {
        Card card = this.creditAccount_.createCard();
        assertEquals(this.creditAccount_.getId(), card.getAccountId()); // Verify that the ids match
    }

    @Test
    void checkTransactionValidity() {
        assertFalse(this.creditAccount_.checkTransactionValidity(150.0)); // Not enough debt
        assertTrue(this.creditAccount_.checkTransactionValidity(50.0)); // Enough debt
    }

    @Test
    void takeMoney() {
        this.creditAccount_.takeMoney(40.0); // Add 40.0 to the debt
        assertEquals(40.0, this.creditAccount_.getCurrentDebt());
    }
}