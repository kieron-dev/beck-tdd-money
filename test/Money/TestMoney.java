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
}
