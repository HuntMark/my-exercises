package my.rinat.effectivejava;

import org.junit.Assert;
import org.junit.Test;

public class PhoneNumberTest {

    @Test
    public void testEquals() {
        PhoneNumber phoneNumber1 = new PhoneNumber((short) 999, (short) 999, (short) 9999);
        PhoneNumber phoneNumber2 = new PhoneNumber((short) 999, (short) 999, (short) 9999);
        Assert.assertEquals(phoneNumber1, phoneNumber2);
    }

    @Test
    public void testNotEquals() {
        PhoneNumber phoneNumber1 = new PhoneNumber((short) 999, (short) 999, (short) 9999);
        PhoneNumber phoneNumber2 = new PhoneNumber((short) 111, (short) 999, (short) 9999);
        Assert.assertNotEquals(phoneNumber1, phoneNumber2);
    }

    @Test
    public void testEqualHashCodes() {
        PhoneNumber phoneNumber1 = new PhoneNumber((short) 999, (short) 999, (short) 9999);
        PhoneNumber phoneNumber2 = new PhoneNumber((short) 999, (short) 999, (short) 9999);
        Assert.assertTrue(phoneNumber1.hashCode() > 0);
        Assert.assertEquals(phoneNumber1.hashCode(), phoneNumber2.hashCode());
    }

    @Test
    public void testNotEqualHashCodes() {
        PhoneNumber phoneNumber1 = new PhoneNumber((short) 999, (short) 999, (short) 9999);
        PhoneNumber phoneNumber2 = new PhoneNumber((short) 111, (short) 999, (short) 9999);
        Assert.assertTrue(phoneNumber1.hashCode() > 0);
        Assert.assertNotEquals(phoneNumber1.hashCode(), phoneNumber2.hashCode());
    }

    @Test
    public void testCompareToGreaterThan() {
        PhoneNumber phoneNumber1 = new PhoneNumber((short) 999, (short) 999, (short) 9999);
        PhoneNumber phoneNumber2 = new PhoneNumber((short) 111, (short) 999, (short) 9999);
        Assert.assertTrue(phoneNumber1.compareTo(phoneNumber2) > 0);
    }

    @Test
    public void testCompareToEquals() {
        PhoneNumber phoneNumber1 = new PhoneNumber((short) 999, (short) 999, (short) 9999);
        PhoneNumber phoneNumber2 = new PhoneNumber((short) 999, (short) 999, (short) 9999);
        Assert.assertEquals(0, phoneNumber1.compareTo(phoneNumber2));
    }

    @Test
    public void testCompareToLessThan() {
        PhoneNumber phoneNumber1 = new PhoneNumber((short) 111, (short) 999, (short) 9999);
        PhoneNumber phoneNumber2 = new PhoneNumber((short) 999, (short) 999, (short) 9999);
        Assert.assertTrue(phoneNumber1.compareTo(phoneNumber2) < 0);
    }
}
