package Money;

import org.junit.Assert;
import org.junit.Test;

public class TestMoney {
    @Test
    public void testMultiplication() {
        Dollar five = new Dollar(5);
        Assert.assertEquals(new Dollar(10), five.times(2));
        Assert.assertEquals(new Dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
        Assert.assertEquals(new Dollar(5), new Dollar(5));
        Assert.assertNotEquals(new Dollar(5), new Dollar(6));
    }

    @Test
    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        Assert.assertEquals(new Franc(10), five.times(2));
        Assert.assertEquals(new Franc(15), five.times(3));
    }
}
