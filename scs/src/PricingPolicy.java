public abstract class PricingPolicy {
	private String category_;
	
	public PricingPolicy(String category) {
		this.category_ = category;
	}

	public void setCategory(String category) {
		this.category_ = category_;
	}

	public String getCategory() {
		return this.category_;
	}

	// Strategy pattern
	// Permet de librement définir de nouvelles politiques tarifaires.
	public abstract double applyDiscount(double price);
}
