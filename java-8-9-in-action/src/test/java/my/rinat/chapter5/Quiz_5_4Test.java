package my.rinat.chapter5;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class Quiz_5_4Test {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void shouldPrintFibonacciTuples() {
        Quiz_5_4.printFibonacciTuples(8);
        Assert.assertEquals("(0,1)\r\n(1,1)\r\n(1,2)\r\n(2,3)\r\n(3,5)\r\n(5,8)\r\n(8,13)\r\n(13,21)\r\n",
                systemOutRule.getLog());
    }
}