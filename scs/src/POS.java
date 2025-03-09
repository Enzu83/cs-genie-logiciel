public class POS {
    private TAS tas_;
    private Card insertCard_;

    public POS(TAS tas) {
        this.insertCard_ = null;
        this.tas_ = tas;
    }

    public void insertCard(Card card) {
        if (this.insertCard_ == null) {
            if (checkCard(card)) {
                this.insertCard_ = card;
                System.out.println("Card valid. Inserted card: " + card);
            }
            else {
                System.out.println("Card invalid. Can't insert card.");
            }
        }
        else {
            System.out.println("A card is already inserted. Can't insert card.");
        }
    }

    public void ejectCard() {
        System.out.println("Card " + this.insertCard_ + " ejected.");
        this.insertCard_ = null;
    }

    public boolean checkCard(Card card) {
        return card != null;
    }

    public boolean checkPIN(int pin) {
        return pin == insertCard_.getPin();
    }

    public void askAuthorization() {
        this.tas_.openSecureConnection();
    }

    public void startTransaction(double amount) {
        if (this.tas_.startTransaction(this.insertCard_.getAccountId(), amount)) {
            System.out.println("Transaction accepted.");
        }

        this.ejectCard();
    }

    public void setTas(TAS tas) {
        this.tas_ = tas;
    }

    public TAS getTas() {
        return this.tas_;
    }

    public Card getInsertCard() {
        return this.insertCard_;
    }

}
