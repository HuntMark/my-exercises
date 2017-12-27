package my.rinat.chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Quiz_5_2Test {

    @Test
    public void shouldReturnSquaresArray() {
        // Given
        Long[] originalNumbers = {1L, 2L, 3L, 4L, 5L};
        Long[] expectedSquares = {1L, 4L, 9L, 16L, 25L};

        // When
        Long[] actualSquares = Quiz_5_2.squaresArray(originalNumbers);

        // Then
        Assert.assertArrayEquals(expectedSquares, actualSquares);
    }

    @Test
    public void shouldReturnAllNumberPairsArray() {
        // Given
        Long[] numbers1 = {1L, 2L, 3L};
        Long[] numbers2 = {3L, 4L};
        Long[][] expectedPairs = {{1L, 3L}, {1L, 4L}, {2L, 3L}, {2L, 4L}, {3L, 3L}, {3L, 4L}};

        // When
        Long[][] actualPairs = Quiz_5_2.allNumberPairs(numbers1, numbers2);

        // Then
        System.out.println(Arrays.deepToString(expectedPairs));
        System.out.println(Arrays.deepToString(actualPairs));
        Assert.assertArrayEquals(expectedPairs, actualPairs);
    }
}