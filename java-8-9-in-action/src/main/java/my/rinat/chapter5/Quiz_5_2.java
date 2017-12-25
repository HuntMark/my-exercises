package my.rinat.chapter5;

import java.util.Arrays;

class Quiz_5_2 {
    static Long[] squaresArray(Long[] numbers) {
        return Arrays.stream(numbers)
                .map(number -> number * number)
                .toArray(Long[]::new);
    }
}
