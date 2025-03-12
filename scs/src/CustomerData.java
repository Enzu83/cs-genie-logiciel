public class CustomerData {
	
	// Very simple way to generate ids: keep a static counter and increment it
	private static int counter_ = 0;
	
	private final int id_;
	private String firstName_;
	private String surname_;
	private CustomerPlan plan_;
	private Address addr_;
	
	public CustomerData(String firstName, String surname, CustomerPlan plan, Address addr) {
		this.id_ = counter_++;
		this.firstName_ = firstName;
		this.surname_ = surname;
		this.plan_ = plan;
		this.addr_ = addr;
	}

	public int getId() {
		return id_;
	}

	public void setFirstName(String firstName) {
		this.firstName_ = firstName;
	}

	public void setSurname(String surname) {
		this.surname_ = surname;
	}

	public void setPlan(CustomerPlan plan) {
		this.plan_ = plan;
	}

	public void setAddr(Address addr) {
		this.addr_ = addr;
	}

	public String getFirstName() {
		return firstName_;
	}

	public String getSurname() {
		return surname_;
	}

	public CustomerPlan getPlan() {
		return plan_;
	}

	public Address getAddr() {
		return addr_;
	}
	
}
