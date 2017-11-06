package my.rinat.chapter2;

public class AppleHeavinessFormatter implements AppleFormatter {
    public String format(Apple apple) {
        return String.format("Apple[heaviness = %s]", apple.getWeight() > 150 ? "heavy" : "light");
    }
}
