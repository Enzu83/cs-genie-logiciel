public class Card {
    private final int pin_;
    private final int number_;
    private final int accountId_;

    public Card(int pin, int number, int accountId) {
        this.pin_ = pin;
        this.number_ = number;
        this.accountId_ = accountId;
    }

    public int getPin() {
        return this.pin_;
    }

    public int getNumber() {
        return this.number_;
    }

    public int getAccountId() {
        return this.accountId_;
    }
}
