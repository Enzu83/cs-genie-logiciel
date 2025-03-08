public interface WeightVisitor {
	// Visitor pattern
	// Calcule le poids d'une instance d'une sous-classe concrète de LineItem
	public double visit(UnitPricedLineItem uli);
	public double visit(WeightPricedLineItem wli);
	
}
