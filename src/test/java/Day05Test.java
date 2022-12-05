package test.java;

import main.java.Input;
import main.java.days.Day05;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day05Test {

    @Test
    private static void part1Test()
    {
        Assert.assertEquals(Day05.part1(Input.testFileBasePath), "CMZ");
    }

    @Test
    private static void part2Test()
    {
        Assert.assertEquals(Day05.part2(Input.testFileBasePath), "MCD");
    }
}
