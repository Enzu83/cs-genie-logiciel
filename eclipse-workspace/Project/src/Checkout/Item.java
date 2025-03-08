package Checkout;

public abstract class Item {
	
	private static int counter_;
	
	private static int getNewID() {
		// A very simple way to get unique IDs: keep a counter and
		// increment it before returning it each time a new ID is requested.
		counter_++;
		return counter_;
	}
	
	private int id_;
	private String label_;

	public Item(String label) {
		super();
		this.id_ = getNewID();
		this.label_ = label;
	}

	public int getId() {
		return id_;
	}

	public String getLabel() {
		return label_;
	}
	
}
