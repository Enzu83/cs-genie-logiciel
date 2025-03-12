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
	
	private double scanLineItemPrice(LineItem lineItem) {
		double lineItemPrice = lineItem.accept(this.priceVisitor_);
		PricingPolicy itemPolicy = this.supermarketData_.findPolicy(lineItem.getItemCategory());
		
		if (itemPolicy != null) {
			lineItemPrice = itemPolicy.applyDiscount(lineItemPrice);
		}
		
		System.out.printf("Scanned %s (%d euros)\n", lineItem.getItemLabel(), lineItemPrice);
		return lineItemPrice;
	}
	
	private double scanLineItemWeight(LineItem lineItem) {
		return lineItem.accept(this.weightVisitor_);
	}
	
	private double computeDeliveryFee(double shippingDistance, double cartWeight, CustomerPlan customerPlan) {
		return customerPlan.applyDeliveryDiscount(3.0 + shippingDistance * cartWeight * 0.5);
	}
	
	public double scanCart(List<LineItem> cart, int customerDataId, boolean deliverToHome) {
		double cartPrice = 0.0;
		double cartWeight = 0.0;
		
		// Sum sub-total prices and weights
		for (LineItem lineItem : cart) {
			cartPrice += this.scanLineItemPrice(lineItem);
			cartWeight += this.scanLineItemWeight(lineItem);
		}
		
		// Take customer plan into account
		CustomerData customerData = this.supermarketData_.findCustomerData(customerDataId);
		CustomerPlan customerPlan = customerData.getPlan();
		cartPrice = customerPlan.applyCartDiscount(cartPrice);
		
		// Take delivery into account
		if (deliverToHome) {
			double shippingDistance = this.supermarketData_.distanceTo(customerData.getAddr());
			return cartPrice + this.computeDeliveryFee(shippingDistance, cartWeight, customerPlan);
		} else {
			return cartPrice;
		}
	}
}
