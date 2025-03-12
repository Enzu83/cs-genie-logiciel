public class WeightPricedLineItem implements LineItem {
	private WeightPricedItem item_;
	private double weight_;
	
	public WeightPricedLineItem(WeightPricedItem item, double kgWeight) {
		this.item_ = item;
		this.weight_ = kgWeight;
	}
	
	public double getPricePerKg() {
		return this.item_.getPricePerKg();
	}
	
	public double getWeight() {
		return this.weight_;
	}
	
	public String getItemLabel() {
		return this.item_.getLabel();
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
