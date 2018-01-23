package my.rinat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

@RunWith(Parameterized.class)
public class Quiz_2_4Test {

    @Parameters(name = "{index}: rangeProduct({0}, {1}) = {2}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(
                (Object[][])
                        new Long[][]{
                                {0L, 1L, 0L},
                                {2L, 2L, 2L},
                                {1L, 4L, 24L},
                                {5L, 15L, 54486432000L}
                        }
        );
    }

    private long first;
    private long last;
    private long expectedProduct;

    public Quiz_2_4Test(long first, long last, long expectedProduct) {
        this.first = first;
        this.last = last;
        this.expectedProduct = expectedProduct;
    }

    @Test
    public void testRangeProduct() {
        LongBinaryOperator product = (a, b) -> (a == b) ? a : LongStream.rangeClosed(a, b).reduce(1, Math::multiplyExact);
        Assert.assertEquals(this.expectedProduct, product.applyAsLong(this.first, this.last));
    }
}