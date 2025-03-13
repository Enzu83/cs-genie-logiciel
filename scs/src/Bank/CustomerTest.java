package Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer customer_;
    private POS pos_;

    @BeforeEach
    void setUp() {
        Card card_ = new Card(0, 1234, "1234567890123456");
        this.customer_ = new Customer(card_, 0);
        this.customer_.setCard(card_);

        this.pos_ = new POS(null);
    }

    @Test
    void insertCard() {
        assertNull(this.pos_.getInsertCard()); // No inserted card

        this.customer_.insertCard(this.pos_);
        assertEquals(this.customer_.getCard(), this.pos_.getInsertCard()); // The inserted card is the customer's one
    }

    @Test
    void typePIN() {
        assertFalse(this.customer_.typePIN(this.pos_, 1234)); // No inserted card, fail to type PIN

        this.customer_.insertCard(this.pos_);
        assertFalse(this.customer_.typePIN(this.pos_, 4376)); // Wrong PIN
        assertTrue(this.customer_.typePIN(this.pos_, 1234)); // Correct PIN
    }
}