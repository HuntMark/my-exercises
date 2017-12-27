package my.rinat.chapter5;

import java.util.Arrays;

class Quiz_5_2 {

    static Long[] squaresArray(Long[] numbers) {
        return Arrays.stream(numbers)
                .map(number -> number * number)
                .toArray(Long[]::new);
    }

    static Long[][] allNumberPairs(Long[] numbers1, Long[] numbers2) {
        return Arrays.stream(numbers1)
                .flatMap(number1 -> Arrays.stream(numbers2)
                        .map(number2 -> new Long[]{number1, number2}))
                .toArray(Long[][]::new);
    }

    static Long[][] numberPairsDivisibleByThree(Long[] numbers1, Long[] numbers2) {
        return Arrays.stream(numbers1)
                .flatMap(number1 -> Arrays.stream(numbers2)
                        .filter(number2 -> (number1 + number2) % 3 == 0)
                        .map(number2 -> new Long[]{number1, number2}))
                .toArray(Long[][]::new);
    }
}
