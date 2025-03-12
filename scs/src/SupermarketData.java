import java.util.List;
import java.util.ArrayList;

public class SupermarketData {
	private Address addr_;
	private Distance distComputer_;
	private List<Item> items_;
	private List<CustomerPlan> plans_;
	private List<PricingPolicy> policies_;
	private List<CustomerData> customers_;
	
	public SupermarketData(Address addr, Distance distComputer) {
		this.addr_ = addr;
		this.distComputer_ = distComputer;
		this.items_ = new ArrayList<Item>();
		this.plans_ = new ArrayList<CustomerPlan>();
		this.policies_ = new ArrayList<PricingPolicy>();
		this.customers_ = new ArrayList<CustomerData>();
	}
	
	public void addItem(Item item) {
		this.items_.add(item);
	}
	
	public void addPlan(CustomerPlan plan) {
		this.plans_.add(plan);
	}
	
	public void addPolicy(PricingPolicy policy) {
		this.policies_.add(policy);
	}
	
	public void addCustomerData(CustomerData customer) {
		this.customers_.add(customer);
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
}
