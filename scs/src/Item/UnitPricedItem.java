package Item;

public class UnitPricedItem extends Item {
	private double pricePerUnit_;
	private double kgPerUnit_;
	
	public UnitPricedItem(String label, String category, double pricePerUnit, double kgPerUnit) {
		super(label, category);
		this.pricePerUnit_ = pricePerUnit;
		this.kgPerUnit_ = kgPerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit_ = pricePerUnit;
	}

	public void setKgPerUnit_(double kgPerUnit_) {
		this.kgPerUnit_ = kgPerUnit_;
	}

	public double getPricePerUnit() {
		return pricePerUnit_;
	}

	public double getKgPerUnit() {
		return kgPerUnit_;
	}

	public String toString() {
		return "UnitPricedItem[id=" + this.id_ + ", label=" + this.label_ + ", category=" + this.category_ + ", pricePerUnit=" + this.pricePerUnit_ + ", kgPerUnit=" + this.kgPerUnit_ + "]";
	}
}
