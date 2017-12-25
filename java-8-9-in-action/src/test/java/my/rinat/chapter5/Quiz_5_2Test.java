package my.rinat.chapter5;

import org.junit.Assert;
import org.junit.Test;

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
}