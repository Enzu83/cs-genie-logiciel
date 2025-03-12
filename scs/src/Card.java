public class Card {
    private final int pin_;
    private final String number_;
    private final int accountId_;

    public Card(int pin, String number, int accountId) {
        this.pin_ = pin;
        this.number_ = number;
        this.accountId_ = accountId;
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
}
