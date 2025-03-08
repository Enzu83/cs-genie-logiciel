package Checkout;

public class ConcreteWeightVisitor implements WeightVisitor {
	
	public float visit(UnitPricedLineItem uli) {
		return uli.getKgPerUnit() * uli.getQuantity();
	}
	
	public float visit(WeightPricedLineItem wli) {
		return wli.getKgWeight();
	}
}
