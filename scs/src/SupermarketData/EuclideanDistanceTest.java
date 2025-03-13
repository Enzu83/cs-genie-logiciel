package SupermarketData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuclideanDistanceTest {

    @Test
    void distanceBetween() {
        EuclideanDistance euclideanDistance = new EuclideanDistance();
        Address address1 = new Address(2.0, 7.0);
        Address address2 = new Address(6.0, 10.0);

        assertEquals(5.0, euclideanDistance.distanceBetween(address1, address2));
    }
}