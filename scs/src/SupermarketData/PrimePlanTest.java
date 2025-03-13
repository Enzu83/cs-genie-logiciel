package SupermarketData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimePlanTest {
    private PrimePlan primePlan_;

    @BeforeEach
    void setUp() {
        primePlan_ = new PrimePlan();
    }

    @Test
    void applyCartDiscount() {
        assertEquals(80.0, primePlan_.applyCartDiscount(100.0));
    }

    @Test
    void applyDeliveryDiscount() {
        assertEquals(50.0, primePlan_.applyDeliveryDiscount(100.0));
    }
}