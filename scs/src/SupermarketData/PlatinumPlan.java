package SupermarketData;

public class PlatinumPlan implements CustomerPlan {
	public double applyCartDiscount(double price) {
		// 30% discount
		return 0.7*price;
	}
	
	public double applyDeliveryDiscount(double fee) {
		// Delivery for platinum customers is for free
		return 0.0;
	}
	
	public double getAnnualFee() {
		// 200€ annual fee
		return 200.0;
	}

	public String toString() {
		return "PlatinumPlan";
	}
}
