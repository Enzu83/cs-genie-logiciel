public abstract class LineItem {
	private PricingPolicy policy_;

	public LineItem(PricingPolicy policy) {
		super();
		this.policy_ = policy;
	}
	
	public abstract float accept(PriceVisitor pv);
	
	// Information expert pour le sous-total du prix.
	public float getSubtotalPrice(PriceVisitor pv) {
		return this.policy_.applyDiscount(this.accept(pv));
	}
	
	// Information expert pour le sous-total du poids.
	public abstract float accept(WeightVisitor wv);
}
