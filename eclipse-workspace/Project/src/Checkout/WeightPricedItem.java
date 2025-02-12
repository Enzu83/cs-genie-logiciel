package Checkout;

public class WeightPricedItem extends Item {
	private float pricePerKg_;

	public WeightPricedItem(String label, float pricePerKg) {
		super(label);
		this.pricePerKg_ = pricePerKg;
	}

	public float getPricePerKg() {
		return pricePerKg_;
	}
	
}
