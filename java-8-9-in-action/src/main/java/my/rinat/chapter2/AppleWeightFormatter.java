package my.rinat.chapter2;

public class AppleWeightFormatter implements AppleFormatter {
    public String format(Apple apple) {
        return String.format("Apple[weight = %d]", apple.getWeight());
    }
}
