package my.rinat.chapter5;

import java.util.stream.Stream;

public class Quiz_5_4 {

    static void printFibonacciTuples(int limit) {
        Stream.iterate(new int[]{0, 1}, tuple -> new int[]{tuple[1], tuple[0] + tuple[1]})
                .limit(limit)
                .forEach(tuple -> System.out.println("(" + tuple[0] + "," + tuple[1] + ")"));
    }
}
