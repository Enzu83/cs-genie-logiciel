public interface PricingPolicy {
	// Strategy pattern
	// Permet de librement définir de nouvelles politiques tarifaires.
	public float applyDiscount(float price);
}
