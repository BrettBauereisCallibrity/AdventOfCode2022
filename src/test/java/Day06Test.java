package test.java;

import main.java.Input;
import main.java.days.Day06;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day06Test {

    @Test
    private static void part1Test()
    {
        Assert.assertEquals(Day06.part1(Input.testFileBasePath), Integer.valueOf(11));
    }

    @Test
    private static void part2Test()
    {
        Assert.assertEquals(Day06.part2(Input.testFileBasePath), Integer.valueOf(26));
    }
}
