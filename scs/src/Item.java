public abstract class Item {

	// Very simple way to generate ids: keep a static counter and increment it
	private static int counter_ = 0;
	
	private int id_;
	private String label_;

	public Item(String label) {
		this.id_ = counter_++;
		this.label_ = label;
	}

	public int getId() {
		return id_;
	}

	public String getLabel() {
		return label_;
	}
	
}
