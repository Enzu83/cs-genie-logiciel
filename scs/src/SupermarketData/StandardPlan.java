package SupermarketData;

public class StandardPlan implements CustomerPlan {
	public double applyCartDiscount(double price) {
		// No discount
		return price;
	}
	
	public double applyDeliveryDiscount(double fee) {
		// No discount
		return fee;
	}
	
	public double getAnnualFee() {
		// No annual fee
		return 0.0;
	}

	public String toString() {
		return "StandardPlan";
	}
}
