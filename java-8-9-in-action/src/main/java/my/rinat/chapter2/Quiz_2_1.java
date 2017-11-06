package my.rinat.chapter2;

import java.util.List;

class Quiz_2_1 {
    static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.format(apple);
            System.out.println(output);
        }
    }
}
