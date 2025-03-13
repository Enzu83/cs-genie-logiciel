package Bank;

public class Customer {
    private Card card_;
    private final int customerDataId;

    public Customer(Card card, int customerDataId) {
        this.card_ = card;
        this.customerDataId = customerDataId;
    }

    public void insertCard(POS pos) {
        pos.insertCard(this.card_);
    }

    public boolean typePIN(POS pos, int pin) {
        return pos.checkPIN(pin);
    }

    public void setCard(Card card) {
        this.card_ = card;
    }

    public Card getCard() {
        return this.card_;
    }

    public int getCustomerDataId() {
        return this.customerDataId;
    }

    public String toString() {
        return "Customer[card_=" + card_ + ", customerDataId=" + customerDataId + "]";
    }
}
