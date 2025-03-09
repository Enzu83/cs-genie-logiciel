public interface LineItem {
	
	// Information expert for the price sub-total.
	// Visitable (visitor pattern for price sub-total).
	public abstract double accept(PriceVisitor pv);
	
	// Information expert for the weight sub-total.
	// Visitable (visitor pattern for weight sub-total).
	public abstract double accept(WeightVisitor wv);
	
	public abstract String getItemCategory();
}
