public class ConcretePriceVisitor implements PriceVisitor {
	
	public float visit(UnitPricedLineItem uli) {
		return uli.getPricePerUnit() * uli.getQuantity();
	}
	
	public float visit(WeightPricedLineItem wli) {
		return wli.getPricePerKg() * wli.getKgWeight();
	}
}
