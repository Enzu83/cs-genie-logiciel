public class PrimePlan implements CustomerPlan {
	public double applyCartDiscount(double price) {
		// 20% discount
		return 0.8*price;
	}
	
	public double applyDeliveryDiscount(double fee) {
		// Prime customers are charged only 50% of the delivery cost
		return 0.5*fee;
	}
	
	public double getAnnualFee() {
		// 50€ annual fee
		return 50.0;
	}
}
