package my.rinat.chapter5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Quiz_5_4Test {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void tearDown() {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    @Test
    public void shouldPrintFibonacciTuples() {
        Quiz_5_4.printFibonacciTuples(8);
        Assert.assertEquals("(0,1)\r\n(1,1)\r\n(1,2)\r\n(2,3)\r\n(3,5)\r\n(5,8)\r\n(8,13)\r\n(13,21)\r\n",
                output.toString());
    }
}