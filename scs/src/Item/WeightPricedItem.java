package Item;

public class WeightPricedItem extends Item {
	private double pricePerKg_;

	public WeightPricedItem(String label, String category, double pricePerKg) {
		super(label, category);
		this.pricePerKg_ = pricePerKg;
	}

	public void setPricePerKg(double pricePerKg) {
		this.pricePerKg_ = pricePerKg;
	}

	public double getPricePerKg() {
		return pricePerKg_;
	}

	public String toString() {
		return "WeightPricedItem[id=" + this.id_ + ", label=" + this.label_ + ", category=" + this.category_ + ", pricePerKg=" + this.pricePerKg_ + "]";
	}
}
