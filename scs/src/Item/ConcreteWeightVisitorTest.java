package Item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteWeightVisitorTest {
    private ConcreteWeightVisitor concreteWeightVisitor_;

    @BeforeEach
    void setUp() {
        concreteWeightVisitor_ = new ConcreteWeightVisitor();
    }

    @Test
    void visitUnitPricedLineItem() {
        UnitPricedItem smartphone = new UnitPricedItem("Smartphone", "Electronic", 650.0, 0.5);
        UnitPricedLineItem uli = new UnitPricedLineItem(smartphone, 3);

        assertEquals(1.5, this.concreteWeightVisitor_.visit(uli));
    }

    @Test
    void visitWeightPricedLineItem() {
        WeightPricedItem apple = new WeightPricedItem("Apple", "Fruits", 1.5);
        WeightPricedLineItem uli = new WeightPricedLineItem(apple, 2.8);

        assertEquals(2.8, this.concreteWeightVisitor_.visit(uli));
    }
}