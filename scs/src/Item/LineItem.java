package Item;

public interface LineItem {
	
	// Information expert for the price sub-total.
	// Visitable (visitor pattern for price sub-total).
	double accept(PriceVisitor pv);
	
	// Information expert for the weight sub-total.
	// Visitable (visitor pattern for weight sub-total).
	double accept(WeightVisitor wv);
	
	String getItemLabel();
	
	String getItemCategory();

	String toString();
}
