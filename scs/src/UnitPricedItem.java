public class UnitPricedItem extends Item {
	private double pricePerUnit_;
	private double kgPerUnit_;
	
	public UnitPricedItem(String label, double pricePerUnit, double kgPerUnit) {
		super(label);
		this.pricePerUnit_ = pricePerUnit;
		this.kgPerUnit_ = kgPerUnit;
	}

	public double getPricePerUnit() {
		return pricePerUnit_;
	}

	public double getKgPerUnit() {
		return kgPerUnit_;
	}
	
}
