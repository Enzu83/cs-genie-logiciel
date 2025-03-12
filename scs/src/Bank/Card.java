package Bank;

public class Card {
    private final int accountId_;
    private final int pin_;
    private final String number_;

    public Card(int accountId, int pin, String number) {
        this.accountId_ = accountId;
        this.pin_ = pin;
        this.number_ = number;
    }

    public int getPin() {
        return this.pin_;
    }

    public String getNumber() {
        return this.number_;
    }

    public int getAccountId() {
        return this.accountId_;
    }

    public String toString() {
        return "Card[accountId=" + this.accountId_ + ", pin=" + this.pin_ + ", number=" + this.number_ + "]";
    }
}
