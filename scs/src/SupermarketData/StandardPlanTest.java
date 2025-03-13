package SupermarketData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardPlanTest {
    private StandardPlan standardPlan_;

    @BeforeEach
    void setUp() {
        standardPlan_ = new StandardPlan();
    }

    @Test
    void applyCartDiscount() {
        assertEquals(100.0, standardPlan_.applyCartDiscount(100.0));
    }

    @Test
    void applyDeliveryDiscount() {
        assertEquals(100.0, standardPlan_.applyDeliveryDiscount(100.0));
    }
}