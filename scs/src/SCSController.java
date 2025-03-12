import Item.*;
import SupermarketData.*;
import Bank.*;

public class SCSController {
    private SupermarketData supermarketData_;
    private CashRegister cashRegister_;

    private Bank bank_;
    private TAS tas_;
    private POS pos_;

    public SCSController(Address address, Distance distComputer, PriceVisitor priceVisitor, WeightVisitor weightVisitor) {
        // Supermarket
        this.supermarketData_ = new SupermarketData(address, distComputer);
        this.cashRegister_ = new CashRegister(priceVisitor, weightVisitor, this.supermarketData_);

        // Bank
        this.bank_ = new Bank();
        this.tas_ = new TAS(this.bank_);
        this.pos_ = new POS(this.tas_);
    }
}
