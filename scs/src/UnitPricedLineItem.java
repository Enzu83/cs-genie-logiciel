public class UnitPricedLineItem implements LineItem {
	private UnitPricedItem item_;
	private int quantity_;
	
	public UnitPricedLineItem(UnitPricedItem item, int quantity) {
		this.item_ = item;
		this.quantity_ = quantity;
	}
	
	public double getPricePerUnit() {
		return this.item_.getPricePerUnit();
	}
	
	public double getKgPerUnit() {
		return this.item_.getKgPerUnit();
	}
	
	public int getQuantity() {
		return this.quantity_;
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
