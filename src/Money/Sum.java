package Money;

/**
 * Created by kieron on 15/10/17.
 */
public class Sum implements Expression {
    Money augend;
    Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(String currency) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, currency);
    }
}
