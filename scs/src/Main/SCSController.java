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

    public void addCustomer(Card card, int customerDataId) {
        this.customers_.add(new Customer(card, customerDataId));
    }

    public Customer getCustomer(int index) {
        return this.customers_.get(index);
    }

    public CustomerPlan getCustomerPlan(int index) {
        return this.customerPlans_.get(index);
    }

    public Account getAccount(int index) {
        return this.bank_.getAccount(index);
    }
}
