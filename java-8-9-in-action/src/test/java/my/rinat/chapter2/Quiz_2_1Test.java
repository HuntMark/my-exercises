package my.rinat.chapter2;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Arrays;
import java.util.List;

public class Quiz_2_1Test {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private List<Apple> inventory = Arrays.asList(new Apple(Color.RED, 200),
            new Apple(Color.GREEN, 100));

    @Test
    public void shouldFormatWithWeightFormatter() {
        Quiz_2_1.prettyPrintApple(inventory, new AppleWeightFormatter());
        Assert.assertEquals("Apple[weight = 200]\r\nApple[weight = 100]\r\n", systemOutRule.getLog());
    }

    @Test
    public void shouldFormatWithHeavinessFormatter() {
        Quiz_2_1.prettyPrintApple(inventory, new AppleHeavinessFormatter());
        Assert.assertEquals("Apple[heaviness = heavy]\r\nApple[heaviness = light]\r\n", systemOutRule.getLog());
    }
}