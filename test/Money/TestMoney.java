package Money;

import org.junit.Assert;
import org.junit.Test;

public class TestMoney {
    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        Assert.assertEquals(Money.dollar(10), five.times(2));
        Assert.assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
        Assert.assertEquals(Money.dollar(5), Money.dollar(5));
        Assert.assertNotEquals(Money.dollar(5), Money.dollar(6));
        Assert.assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @Test
    public void testCurrencies() {
        Assert.assertEquals("USD", Money.dollar(1).currency());
        Assert.assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        Assert.assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        Assert.assertEquals(five, sum.augend);
        Assert.assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum() {
        Expression sum =  Money.dollar(2).plus(Money.dollar(3));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        Assert.assertEquals(Money.dollar(5), result);
    }

    @Test
    public void testReduceMoney() {
        Expression money = Money.dollar(5);
        Bank bank = new Bank();
        Money result = bank.reduce(money, "USD");
        Assert.assertEquals(Money.dollar(5), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        Assert.assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testIdentityRate() {
        Assert.assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition() {
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        Assert.assertEquals(Money.dollar(10), result);
    }
}
