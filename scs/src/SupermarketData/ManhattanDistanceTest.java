package SupermarketData;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManhattanDistanceTest {

    @Test
    void distanceBetween() {
        ManhattanDistance manhattanDistance = new ManhattanDistance();
        Address address1 = new Address(15.0, 3.0);
        Address address2 = new Address(6.0, 1.0);

        assertEquals(11.0, manhattanDistance.distanceBetween(address1, address2));
    }
}