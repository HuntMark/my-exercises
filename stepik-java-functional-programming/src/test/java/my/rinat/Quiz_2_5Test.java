package my.rinat;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Quiz_2_5Test {

    @Test
    public void lambda_should_leave_distinct_words() {
        // Given
        Function<List<String>, List<String>> distinct = (words) -> words.stream().distinct().collect(Collectors.toList());

        // When
        List<String> actualWords = distinct.apply(Arrays.asList("java", "scala", "java", "clojure", "clojure"));

        // Then
        MatcherAssert.assertThat(actualWords, Matchers.contains("java", "scala", "clojure"));
    }
}