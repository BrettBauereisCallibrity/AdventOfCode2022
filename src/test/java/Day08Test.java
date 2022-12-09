package test.java;

import main.java.Input;
import main.java.days.Day08;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Day08Test {

    @Test
    private static void part1Test()
    {
        Assert.assertEquals(Day08.part1(Input.testFileBasePath), Integer.valueOf(21));
    }

    @Test
    private static void part2Test()
    {
        Assert.assertEquals(Day08.part2(Input.testFileBasePath), Integer.valueOf(8));
    }
}
