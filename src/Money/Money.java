package Money;

public class Money {
    protected int amount;

    public boolean equals(Object other) {
        Money money = (Money)other;
        return money.amount == amount;
    }
}
