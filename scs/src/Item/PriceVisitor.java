package Item;

public interface PriceVisitor {
	// Visitor pattern
	// Calcule le prix d'une instance d'une sous-classe concrète de LineItem
	double visit(UnitPricedLineItem uli);
	double visit(WeightPricedLineItem wli);
}
