package SupermarketData;

import java.lang.Math;

public class ManhattanDistance implements Distance{
	public double distanceBetween(Address addr1, Address addr2) {
		return Math.abs(addr1.getX() - addr2.getX()) + Math.abs(addr1.getY() - addr2.getY());
	}

	public String toString() {
		return "Manhattan Distance";
	}
}
