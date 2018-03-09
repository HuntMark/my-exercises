package my.rinat;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.LongStream;

public class Quiz_2_17Test {

    @Test
    public void testPrimeNumber() {
        Assert.assertTrue(isPrime(2));
        Assert.assertTrue(isPrime(3));
        Assert.assertTrue(isPrime(5));
        Assert.assertTrue(isPrime(7));
        Assert.assertTrue(isPrime(11));
        Assert.assertTrue(isPrime(13));
        Assert.assertTrue(isPrime(17));
        Assert.assertTrue(isPrime(19));
        Assert.assertFalse(isPrime(4));
        Assert.assertFalse(isPrime(6));
        Assert.assertFalse(isPrime(8));
        Assert.assertFalse(isPrime(9));
        Assert.assertFalse(isPrime(10));
        Assert.assertFalse(isPrime(12));
        Assert.assertFalse(isPrime(14));
        Assert.assertFalse(isPrime(15));
        Assert.assertFalse(isPrime(16));
        Assert.assertFalse(isPrime(18));
        Assert.assertFalse(isPrime(20));
    }

    /**
     * Checking if a number is prime
     *
     * @param number to test >= 2
     * @return true if number is prime else false
     */
    private static boolean isPrime(final long number) {
        return (number == 2 || number == 3) ||
                LongStream
                        .rangeClosed(2, number / 2)
                        .noneMatch(divisor -> number % divisor == 0);
    }
}
