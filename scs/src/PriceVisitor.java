public interface PriceVisitor {
	// Visitor pattern
	// Calcule le prix d'une instance d'une sous-classe concrète de LineItem
	public double visit(UnitPricedLineItem uli);
	public double visit(WeightPricedLineItem wli);
}
