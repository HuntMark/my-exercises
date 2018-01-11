package my.rinat.chapter5;

import static my.rinat.chapter5.Transaction.transactions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TradersAndTransactions {

    public static void main(String[] args) {
        printAllTransactions();
        printMessageSeparator("Exercise 1");
        printExercise1();
        printMessageSeparator("Exercise 2");
        printExercise2();
        printMessageSeparator("Exercise 3");
        printExercise3();
    }

    private static void printExercise1() {
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList())
                .forEach(Printer::print);
    }

    private static void printExercise2() {
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList())
                .forEach(Printer::print);
    }

    private static void printExercise3() {
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList())
                .forEach(Printer::print);
    }

    private static void printMessageSeparator(String message) {
        System.out.println("==================== " + message);
    }

    private static <T> void printlnList(List<T> elements) {
        elements.forEach(System.out::println);
    }

    private static void printAllTransactions() {
        printMessageSeparator("All transactions");
        printlnList(transactions);
    }

    private static class Printer {
        static void print(Object something) {
            System.out.println(something);
        }
    }
}
