public class WeightPricedLineItem extends LineItem {
	private WeightPricedItem item_;
	private double kgWeight_;
	
	public WeightPricedLineItem(WeightPricedItem item, double kgWeight, PricingPolicy policy) {
		super(policy);
		this.item_ = item;
		this.kgWeight_ = kgWeight;
	}
	
	public double getPricePerKg() {
		return this.item_.getPricePerKg();
	}
	
	public double getKgWeight() {
		return this.kgWeight_;
	}
	
	public double accept(PriceVisitor pv) {
		return pv.visit(this);
	}
	
	public double accept(WeightVisitor wv) {
		return wv.visit(this);
	}
}
