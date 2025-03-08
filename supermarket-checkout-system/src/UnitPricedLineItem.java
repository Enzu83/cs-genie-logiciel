package Checkout;

public class UnitPricedLineItem extends LineItem {
	private UnitPricedItem item_;
	private int quantity_;
	
	public UnitPricedLineItem(UnitPricedItem item, int quantity, PricingPolicy policy) {
		super(policy);
		this.item_ = item;
		this.quantity_ = quantity;
	}
	
	public float getPricePerUnit() {
		return this.item_.getPricePerUnit();
	}
	
	public float getKgPerUnit() {
		return this.item_.getKgPerUnit();
	}
	
	public int getQuantity() {
		return this.quantity_;
	}
	
	public float accept(PriceVisitor pv) {
		return pv.visit(this);
	}
	
	public float accept(WeightVisitor wv) {
		return wv.visit(this);
	}
}
