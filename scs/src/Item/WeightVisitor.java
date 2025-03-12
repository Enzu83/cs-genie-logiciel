package Item;

public interface WeightVisitor {
	// Visitor pattern
	// Calcule le poids d'une instance d'une sous-classe concrète de LineItem
	double visit(UnitPricedLineItem uli);
	double visit(WeightPricedLineItem wli);
	String toString();
}
