package SupermarketData;

import java.util.List;
import java.util.ArrayList;

public class SupermarketData {
	private Address addr_;
	private Distance distComputer_;
	private List<PricingPolicy> policies_;
	private List<CustomerData> customers_;
	
	public SupermarketData(Address addr, Distance distComputer) {
		this.addr_ = addr;
		this.distComputer_ = distComputer;
		this.policies_ = new ArrayList<PricingPolicy>();
		this.customers_ = new ArrayList<CustomerData>();
	}
	
	public void addPolicy(PricingPolicy policy) {
		this.policies_.add(policy);
	}
	
	public void addCustomerData(String firstName, String surname, CustomerPlan plan, Address addr) {
		// Creator pattern: SupermarketData aggregates CustomerData instances
		// and thus is responsible for creating them.
		this.customers_.add(new CustomerData(firstName, surname, plan, addr));
	}
	
	public double distanceTo(Address addr) {
		return this.distComputer_.distanceBetween(this.addr_, addr);
	}
	
	public PricingPolicy findPolicy(String category) {
		for (PricingPolicy policy : this.policies_) {
			if (policy.getCategory().equals(category)) {
				return policy;
			}
		}
		return null;
	}

	public CustomerData findCustomerData(int customerDataId) {
		for (CustomerData customerData : this.customers_) {
			if (customerData.getId() == customerDataId) {
				return customerData;
			}
		}
		return null;
	}

	public CustomerData getCustomerData(int index) { return this.customers_.get(index); }

	public void setDistComputer(Distance distComputer) {
		this.distComputer_ = distComputer;
	}

	public String toString() {
		return "SupermarketData[addr=" + this.addr_ + ", distComputer=" + this.distComputer_ + ", policies=" + this.policies_ + ", customers=" + this.customers_ + "]";
	}
}
