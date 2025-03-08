public class WeightPricedItem extends Item {
	private double pricePerKg_;

	public WeightPricedItem(String label, double pricePerKg) {
		super(label);
		this.pricePerKg_ = pricePerKg;
	}

	public double getPricePerKg() {
		return pricePerKg_;
	}
	
}
