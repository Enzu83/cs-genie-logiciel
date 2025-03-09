public class WeightPricedLineItem implements LineItem {
	private WeightPricedItem item_;
	private double kgWeight_;
	
	public WeightPricedLineItem(WeightPricedItem item, double kgWeight) {
		this.item_ = item;
		this.kgWeight_ = kgWeight;
	}
	
	public double getPricePerKg() {
		return this.item_.getPricePerKg();
	}
	
	public double getKgWeight() {
		return this.kgWeight_;
	}
	
	public String getItemCategory() {
		return this.item_.getCategory();
	}
	
	public double accept(PriceVisitor pv) {
		return pv.visit(this);
	}
	
	public double accept(WeightVisitor wv) {
		return wv.visit(this);
	}
}
