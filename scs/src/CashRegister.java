import java.util.List;

public class CashRegister {
	private PriceVisitor priceVisitor_;
	private WeightVisitor weightVisitor_;
	private SupermarketData supermarketData_;
	
	public CashRegister(PriceVisitor priceVisitor, WeightVisitor weightVisitor, SupermarketData supermarketData) {
		this.priceVisitor_ = priceVisitor;
		this.weightVisitor_ = weightVisitor;
		this.supermarketData_ = supermarketData;
	}
	
	public double scanCart(List<LineItem> cart) {
		double cartPrice = 0.0;
		// TODO
		//for (LineItem li: cart) {
		//	double liPrice = li.accept(priceVisitor_)
		//}
		return cartPrice; // What about the full weight to compute the delivery fees ?
	}
}
