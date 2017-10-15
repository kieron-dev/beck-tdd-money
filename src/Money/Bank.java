package Money;

public class Bank {
    public Money reduce(Expression expr, String currency) {
        Sum sum = (Sum) expr;
        return new Money(sum.augend.amount + sum.addend.amount, currency);
    }
}
