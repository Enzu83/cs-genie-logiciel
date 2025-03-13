package SupermarketData;

import Bank.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketDataTest {
    private SupermarketData supermarketData_;

    @BeforeEach
    void setUp() {
        Address address = new Address(5.0, 7.0);
        this.supermarketData_ = new SupermarketData(address, new ManhattanDistance());
    }

    @Test
    void distanceToManhattan() {
        Address shippingAddress = new Address(2.0, 8.0);

        this.supermarketData_.setDistComputer(new ManhattanDistance());
        assertEquals(4.0, this.supermarketData_.distanceTo(shippingAddress));
    }

    @Test
    void distanceToEuclidian() {
        Address shippingAddress = new Address(2.0, 3.0);

        this.supermarketData_.setDistComputer(new EuclideanDistance());
        assertEquals(5.0, this.supermarketData_.distanceTo(shippingAddress));
    }

    @Test
    void findPolicy() {
        DairyPolicy dairyPolicy = new DairyPolicy();
        FreshVeggiesPolicy freshVeggiesPolicy = new FreshVeggiesPolicy();

        // Add policies
        this.supermarketData_.addPolicy(dairyPolicy);
        this.supermarketData_.addPolicy(freshVeggiesPolicy);

        // Find those policies by their category label
        assertEquals(dairyPolicy, this.supermarketData_.findPolicy("Dairy"));
        assertEquals(freshVeggiesPolicy, this.supermarketData_.findPolicy("Vegetables"));

        // Search a non-existent policy
        assertNull(this.supermarketData_.findPolicy("Fruit"));
    }

    @Test
    void findCustomerData() {
        // Add a customer data to the supermarket
        this.supermarketData_.addCustomerData("Madeline", "Celeste", new StandardPlan(), new Address(49.34, 125.24));

        // Check if the customer data is correctly found
        assertEquals(0, this.supermarketData_.findCustomerData(0).getId());

        // Check a non-existent customer data
        assertNull(this.supermarketData_.findCustomerData(1));
    }
}