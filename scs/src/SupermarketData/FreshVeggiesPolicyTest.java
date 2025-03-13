package SupermarketData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreshVeggiesPolicyTest {
    private FreshVeggiesPolicy freshVeggiesPolicy_;

    @BeforeEach
    void setUp() {
        freshVeggiesPolicy_ = new FreshVeggiesPolicy();
    }

    @Test
    void applyDiscount() {
        assertEquals(0.9, freshVeggiesPolicy_.applyDiscount(1.0)); // reduction factor of x0.9
    }
}