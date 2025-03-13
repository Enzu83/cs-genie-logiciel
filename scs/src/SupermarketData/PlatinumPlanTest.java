package SupermarketData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatinumPlanTest {
    private PlatinumPlan platinumPlan_;

    @BeforeEach
    void setUp() {
        platinumPlan_ = new PlatinumPlan();
    }

    @Test
    void applyCartDiscount() {
        assertEquals(70.0, platinumPlan_.applyCartDiscount(100.0));
    }

    @Test
    void applyDeliveryDiscount() {
        assertEquals(0.0, platinumPlan_.applyDeliveryDiscount(100.0));
    }
}