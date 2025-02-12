package Checkout;

public class UnitPricedItem extends Item {
	private float pricePerUnit_;
	private float kgPerUnit_;
	
	public UnitPricedItem(String label, float pricePerUnit, float kgPerUnit) {
		super(label);
		this.pricePerUnit_ = pricePerUnit;
		this.kgPerUnit_ = kgPerUnit;
	}

	public float getPricePerUnit() {
		return pricePerUnit_;
	}

	public float getKgPerUnit() {
		return kgPerUnit_;
	}
	
}
