package SupermarketData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DairyPolicyTest {
    private DairyPolicy dairyPolicy_;

    @BeforeEach
    void setUp() {
        dairyPolicy_ = new DairyPolicy();
    }

    @Test
    void applyDiscount() {
        assertEquals(0.95, dairyPolicy_.applyDiscount(1.0)); // reduction factor of x0.95
        assertEquals(85.0, dairyPolicy_.applyDiscount(100.0)); // reduction factor of x0.85 (price >= 20.0)
    }
}