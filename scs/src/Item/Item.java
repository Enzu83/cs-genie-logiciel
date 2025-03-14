package Item;

public abstract class Item {

	// Very simple way to generate ids: keep a static counter and increment it
	private static int counter_ = 0;
	
	protected int id_;
	protected String label_;
	protected String category_;

	public Item(String label, String category) {
		this.id_ = counter_++;
		this.label_ = label;
		this.category_ = category;
	}

	public int getId() {
		return id_;
	}

	public String getLabel() {
		return label_;
	}
	
	public String getCategory() {
		return this.category_;
	}

	public abstract String toString();
}
