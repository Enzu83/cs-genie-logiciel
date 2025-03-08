public interface WeightVisitor {
	// Visitor pattern
	// Calcule le poids d'une instance d'une sous-classe concrète de LineItem
	public float visit(UnitPricedLineItem uli);
	public float visit(WeightPricedLineItem wli);
	
}
