package SupermarketData;

import java.lang.Math;

public class EuclideanDistance implements Distance {
	public double distanceBetween(Address addr1, Address addr2) {
		return Math.sqrt(Math.pow(addr1.getX() - addr2.getX(), 2) + Math.pow(addr1.getY() - addr2.getY(), 2));
	}

	public String toString() {
		return "Euclidean Distance";
	}
}
