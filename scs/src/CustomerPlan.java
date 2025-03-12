public interface CustomerPlan {
	double applyCartDiscount(double price);
	double applyDeliveryDiscount(double fee);
	double getAnnualFee();
}
