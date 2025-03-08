public interface PricingPolicy {
	// Strategy pattern
	// Permet de librement définir de nouvelles politiques tarifaires.
	public double applyDiscount(double price);
}
