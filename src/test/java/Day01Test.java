package test.java;

import main.java.Input;
import main.java.days.Day01;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day01Test {

    @Test
    private static void part1Test()
    {
        Assert.assertEquals(Integer.valueOf(24000), Day01.part1(Input.testFileBasePath));
    }

    @Test
    private static void part2Test()
    {
        Assert.assertEquals(Integer.valueOf(45000), Day01.part2(Input.testFileBasePath));
    }

}
