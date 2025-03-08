public abstract class LineItem {
	private PricingPolicy policy_;

	public LineItem(PricingPolicy policy) {
		this.policy_ = policy;
	}
	
	public abstract double accept(PriceVisitor pv);
	
	// Information expert pour le sous-total du prix.
	public double getSubtotalPrice(PriceVisitor pv) {
		return this.policy_.applyDiscount(this.accept(pv));
	}
	
	// Information expert pour le sous-total du poids.
	public abstract double accept(WeightVisitor wv);
}
