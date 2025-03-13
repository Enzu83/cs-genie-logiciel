package Bank;

public class POS {
    private TAS tas_;
    private Card insertedCard_;

    public POS(TAS tas) {
        this.insertedCard_ = null;
        this.tas_ = tas;
    }

    public void insertCard(Card card) {
        if (this.insertedCard_ == null) {
            if (checkCard(card)) {
                this.insertedCard_ = card;
                System.out.println("Card valid. Inserted card: " + this.insertedCard_);
            } else {
                System.out.println("Card invalid. Can't insert card: " + card);
            }
        } else {
            System.out.println("A card is already inserted. Can't insert card.");
        }
    }

    public void ejectCard() {
        System.out.println(this.insertedCard_ + " ejected.");
        this.insertedCard_ = null;
    }

    public boolean checkCard(Card card) {
        return card != null;
    }

    public boolean checkPIN(int pin) {
        if (insertedCard_ == null) {
            System.out.println("No card inserted. Can't check PIN.");
            return false;
        } else {
            return pin == insertedCard_.getPin();
        }
    }

    public boolean askAuthorization() {
        return this.tas_.openSecureConnection();
    }

    public boolean startTransaction(double amount) {
        if (this.insertedCard_ == null) {
            System.out.println("No card inserted. Can't start transaction.");
            return false;
        } 
        else if (this.tas_.startTransaction(this.insertedCard_.getAccountId(), amount)) {
            System.out.println("Transaction accepted.");
            this.ejectCard();
            return true;
        }
        else {
            return false;
        }
    }

    public void setTas(TAS tas) {
        this.tas_ = tas;
    }

    public TAS getTas() {
        return this.tas_;
    }

    public Card getInsertCard() {
        return this.insertedCard_;
    }

    public String toString() {
        return "POS[TAS=" + this.tas_ + ", insertedCard=" + this.insertedCard_ + "]";
    }
}
