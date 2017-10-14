package Money;

public abstract class Money {
    protected int amount;

    public boolean equals(Object other) {
        Money money = (Money)other;
        return money.amount == amount && money.getClass() == getClass();
    }

    static Money dollar(int amount) {
        return new Dollar(amount);
    }

    static Money franc(int amount) {
        return new Franc(amount);
    }

    abstract Money times(int multiplier);
}
