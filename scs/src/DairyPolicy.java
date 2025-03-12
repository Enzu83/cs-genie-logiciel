public class DairyPolicy extends PricingPolicy {
	
	public DairyPolicy() {
		super("Dairy");
	}
	
	public double applyDiscount(double price) {
		// A 5% discount on dairy products, which rises to 15% instead
		// if more that 20€ of the same product is bought at once.
		if (price >= 20) {
			return 0.85*price;
		}
		else {
			return 0.95*price;
		}
	}
}
