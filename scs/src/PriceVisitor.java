public interface PriceVisitor {
	// Visitor pattern
	// Calcule le prix d'une instance d'une sous-classe concrète de LineItem
	public float visit(UnitPricedLineItem uli);
	public float visit(WeightPricedLineItem wli);
}
