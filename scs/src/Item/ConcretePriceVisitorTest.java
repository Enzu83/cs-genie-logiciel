package Item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcretePriceVisitorTest {
    private ConcretePriceVisitor concretePriceVisitor_;

    @BeforeEach
    void setUp() {
        concretePriceVisitor_ = new ConcretePriceVisitor();
    }

    @Test
    void visitUnitPricedLineItem() {
        UnitPricedItem smartphone = new UnitPricedItem("Smartphone", "Electronic", 650.0, 0.5);
        UnitPricedLineItem uli = new UnitPricedLineItem(smartphone, 3);

        assertEquals(1950.0, this.concretePriceVisitor_.visit(uli));
    }

    @Test
    void visitWeightPricedLineItem() {
        WeightPricedItem apple = new WeightPricedItem("Apple", "Fruits", 1.5);
        WeightPricedLineItem uli = new WeightPricedLineItem(apple, 2.0);

        assertEquals(3.0, this.concretePriceVisitor_.visit(uli));
    }
}