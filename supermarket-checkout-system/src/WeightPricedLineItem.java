package Checkout;

public class WeightPricedLineItem extends LineItem {
	private WeightPricedItem item_;
	private float kgWeight_;
	
	public WeightPricedLineItem(WeightPricedItem item, float kgWeight, PricingPolicy policy) {
		super(policy);
		this.item_ = item;
		this.kgWeight_ = kgWeight;
	}
	
	public float getPricePerKg() {
		return this.item_.getPricePerKg();
	}
	
	public float getKgWeight() {
		return this.kgWeight_;
	}
	
	public float accept(PriceVisitor pv) {
		return pv.visit(this);
	}
	
	public float accept(WeightVisitor wv) {
		return wv.visit(this);
	}
}
