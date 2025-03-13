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
                System.out.println("[POS]: Card valid. Inserted card: " + this.insertedCard_);
            } else {
                System.out.println("[POS]: Card invalid. Can't insert card: " + card);
            }
        } else {
            System.out.println("[POS]: A card is already inserted. Can't insert card.");
        }
    }

    public void ejectCard() {
        if (this.insertedCard_ == null) {
            System.out.println("[POS]: Can't eject card. There is none.");
        }
        else {
            System.out.println("[POS]: " + this.insertedCard_ + " ejected.");
            this.insertedCard_ = null;
        }
    }

    public boolean checkCard(Card card) {
        return card != null;
    }

    public boolean checkPIN(int pin) {
        if (insertedCard_ == null) {
            System.out.println("[POS]: No card inserted. Can't check PIN.");
            return false;
        } else {
            return pin == insertedCard_.getPin();
        }
    }

    public boolean askAuthorization() {
        if (this.tas_.openSecureConnection()) {
            System.out.println("[POS]: Authorization successful. Starting transaction.");
            return true;
        }
        else {
            System.out.println("[POS]: Couldn't open secure connection with the TAS. End of transaction.");
            return false;
        }
    }

    public boolean startTransaction(double amount) {
        if (this.insertedCard_ == null) {
            System.out.println("[POS]: No card inserted. Can't start transaction.");
            return false;
        } 
        else if (this.tas_.startTransaction(this.insertedCard_.getAccountId(), amount)) {
            System.out.println("[POS]: Payment successful. Transaction completed.");
            return true;
        }
        else {
            System.out.println("[POS]: Payment failed. Transaction aborted.");
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
