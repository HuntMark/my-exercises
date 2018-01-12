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
        printMessageSeparator("Exercise 4");
        printExercise4();
        printMessageSeparator("Exercise 5");
        printExercise5();
        printMessageSeparator("Exercise 6");
        printExercise6();
        printMessageSeparator("Exercise 7");
        printExercise7();
        printMessageSeparator("Exercise 8");
        printExercise8();
    }

    private static void printExercise1() {
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .forEach(Printer::print);
    }

    private static void printExercise2() {
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(Printer::print);
    }

    private static void printExercise3() {
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .forEach(Printer::print);
    }

    private static void printExercise4() {
        String result = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        Printer.print(result);
    }

    private static void printExercise5() {
        final String city = "Milan";
        boolean areAnyTradersBasedInMilan = transactions.stream()
                .anyMatch(transaction -> city.equalsIgnoreCase(transaction.getTrader().getCity()));
        Printer.print("Are any traders based in " + city + "? " + (areAnyTradersBasedInMilan ? "Yes" : "No"));
    }

    private static void printExercise6() {
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(Printer::print);
    }

    private static void printExercise7() {
        transactions.stream()
                .map(Transaction::getValue)
                .max(Comparator.naturalOrder())
                .ifPresent(Printer::print);
    }

    private static void printExercise8() {
        transactions.stream()
                .map(Transaction::getValue)
                .min(Comparator.naturalOrder())
                .ifPresent(Printer::print);
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
