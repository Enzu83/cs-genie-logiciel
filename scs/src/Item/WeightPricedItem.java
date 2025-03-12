package Item;

public class WeightPricedItem extends Item {
	private double pricePerKg_;

	public WeightPricedItem(String label, String category, double pricePerKg) {
		super(label, category);
		this.pricePerKg_ = pricePerKg;
	}

	public double getPricePerKg() {
		return pricePerKg_;
	}
	
}
