package my.rinat;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

public class Quiz_2_12Test {

    @Test
    public void test() {
        IntPredicate intPredicate = disjunctAll(intPredicates);
        Assert.assertFalse(intPredicate.test(-1));
        Assert.assertTrue(intPredicate.test(1));
    }

    private static final List<IntPredicate> intPredicates = Arrays.asList(
            (value -> value > 0),
            (value -> value == 1),
            (value -> value > 0 && value < 2)
    );

    /**
     * The method represents a disjunct operator for a list of predicates.
     * For an empty list it returns the always false predicate.
     */
    private static IntPredicate disjunctAll(List<IntPredicate> predicates) {

        if (predicates.isEmpty()) {
            return (value -> false);
        }

        if (predicates.size() == 1) {
            return predicates.get(0);
        }

        IntPredicate cumulativePredicate = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            cumulativePredicate = cumulativePredicate.or(predicates.get(i));
        }
        return cumulativePredicate;
    }

}
