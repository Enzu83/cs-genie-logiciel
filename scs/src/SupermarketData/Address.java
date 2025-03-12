package SupermarketData;

public class Address {
	private double x_;
	private double y_;
	
	public Address(double x, double y) {
		this.x_ = x;
		this.y_ = y;
	}

	public void setPoint(double x, double y) {
		this.x_ = x;
		this.y_ = y;
	}

	public double getX() {
		return x_;
	}

	public double getY() {
		return y_;
	}
	
}
