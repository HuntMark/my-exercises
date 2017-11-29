package my.rinat.chapter2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class Quiz_2_1Test {

    private List<Apple> inventory = Arrays.asList(new Apple(Color.RED, 200),
            new Apple(Color.GREEN, 100));
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }

    @Test
    public void shouldFormatWithWeightFormatter() {
        Quiz_2_1.prettyPrintApple(inventory, new AppleWeightFormatter());
        Assert.assertEquals("Apple[weight = 200]\r\nApple[weight = 100]\r\n", output.toString());
    }

    @Test
    public void shouldFormatWithHeavinessFormatter() {
        Quiz_2_1.prettyPrintApple(inventory, new AppleHeavinessFormatter());
        Assert.assertEquals("Apple[heaviness = heavy]\r\nApple[heaviness = light]\r\n", output.toString());
    }
}