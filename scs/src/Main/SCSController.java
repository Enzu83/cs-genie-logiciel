package Main;

import Item.*;
import SupermarketData.*;
import Bank.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SCSController {
    private SupermarketData supermarketData_;
    private CashRegister cashRegister_;
    private List<Customer> customers_;
    private List<CustomerPlan> customerPlans_;
    private List<Item> items_;

    private Bank bank_;
    private TAS tas_;
    private POS pos_;

    public SCSController(Address address, Distance distComputer, PriceVisitor priceVisitor, WeightVisitor weightVisitor) {
        // Supermarket
        this.supermarketData_ = new SupermarketData(address, distComputer);
        this.cashRegister_ = new CashRegister(priceVisitor, weightVisitor, this.supermarketData_);
        this.customers_ = new ArrayList<Customer>();
        this.customerPlans_ = new ArrayList<CustomerPlan>(Arrays.asList(
                new StandardPlan(),
                new PrimePlan(),
                new PlatinumPlan()
        ));
        this.items_ = new ArrayList<Item>();

        // Bank
        this.bank_ = new Bank();
        this.tas_ = new TAS(this.bank_);
        this.pos_ = new POS(this.tas_);
    }

    public void addCreditAccount(double balance, double maxDebt) {
        this.bank_.addCreditAccount(balance, maxDebt);
    }

    public void addDebitAccount(double balance) {
        this.bank_.addDebitAccount(balance);
    }

    public void addCustomerData(String firstName, String surname, CustomerPlan plan, Address addr) {
        this.supermarketData_.addCustomerData(firstName, surname, plan, addr);
    }

    public void addCustomer(Card card, int customerDataId) {
        this.customers_.add(new Customer(card, customerDataId));
    }

    public void addUnitPricedItem(String label, String category, double pricePerUnit, double kgPerUnit) {
        this.items_.add(new UnitPricedItem(label, category, pricePerUnit, kgPerUnit));
    }

    public void addWeightPricedItem(String label, String category, double pricePerKg) {
        this.items_.add(new WeightPricedItem(label, category, pricePerKg));
    }

    public Item findItem(int itemId) {
        for (Item item : this.items_) {
            if (item.getId() == itemId) {
                return item;
            }
        }

        return null;
    }

    public void addUnitPricedLineItemToCart(List<LineItem> cart, int itemId, int quantity) {
        Item item = findItem(itemId);

        // Check if the corresponding item is a unit priced item
        if (item instanceof UnitPricedItem) {
            cart.add(new UnitPricedLineItem((UnitPricedItem) item, quantity));
        }
        // If it's not, don't add it
        else {
            System.out.println("Can't add item to cart. Expected a UnitPricedItem. Got: " + item + ".");
        }
    }

    public void addWeightPricedLineItemToCart(List<LineItem> cart, int itemId, double kgWeight) {
        Item item = findItem(itemId);

        // Check if the corresponding item is a weight priced item
        if (item instanceof WeightPricedItem) {
            cart.add(new WeightPricedLineItem((WeightPricedItem) item, kgWeight));
        }
        // If it's not, don't add it
        else {
            System.out.println("Can't add item to cart. Expected a WeightPricedItem. Got: " + item + ".");
        }
    }

    public CashRegister getCashRegister() { return this.cashRegister_; }

    public Customer getCustomer(int index) {
        return this.customers_.get(index);
    }

    public CustomerPlan getCustomerPlan(int index) {
        return this.customerPlans_.get(index);
    }

    public Account getAccount(int index) { return this.bank_.getAccount(index); }

    public Item getItem(int index) { return this.items_.get(index); }

    public POS getPOS() { return this.pos_; }
}
