package Money;

public class Bank {
    public Money reduce(Expression expr, String currency) {
        return expr.reduce(currency);
    }
}
