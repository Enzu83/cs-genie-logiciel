public class ConcretePriceVisitor implements PriceVisitor {
	
	public double visit(UnitPricedLineItem uli) {
		return uli.getPricePerUnit() * uli.getQuantity();
	}
	
	public double visit(WeightPricedLineItem wli) {
		return wli.getPricePerKg() * wli.getKgWeight();
	}
}
