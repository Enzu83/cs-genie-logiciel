public interface CustomerPlan {
	public double applyCartDiscount(double price);
	public double applyDeliveryDiscount(double fee);
	public double getAnnualFee();
}
