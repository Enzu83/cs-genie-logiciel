package SupermarketData;

public class FreshVeggiesPolicy extends PricingPolicy {
	
	public FreshVeggiesPolicy() {
		super("Vegetables");
	}
	
	public double applyDiscount(double price) {
		// A 10% discount on vegetables
		return 0.9*price;
	}

	public String toString() {
		return "Fresh Veggies Policy";
	}
}
