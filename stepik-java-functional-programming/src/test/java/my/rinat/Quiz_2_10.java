package my.rinat;

import org.junit.Assert;
import org.junit.Test;

public class Quiz_2_10 {

    @Test
    public void test1() {
        Assert.assertTrue(allValuesAreDifferentPredicate.test(1, 2, 3));
        Assert.assertFalse(allValuesAreDifferentPredicate.test(1, 2, 2));
        Assert.assertFalse(allValuesAreDifferentPredicate.test(2, 2, 2));
    }

    @FunctionalInterface
    public interface TernaryIntPredicate {
        boolean test(int a, int b, int c);
    }

    public static final TernaryIntPredicate allValuesAreDifferentPredicate = (a, b, c) -> (a != b) && (a != c) && (b != c);

}
