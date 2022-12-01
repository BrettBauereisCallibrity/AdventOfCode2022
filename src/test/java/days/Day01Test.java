package test.java.days;

import main.java.days.Day01;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day01Test {

    private static String baseFilePath = "/Users/brettdouglasbauereis/Repos/AdventOfCode2022/src/test/Resources/";

    @Test
    private static void part1Test()
    {
        Assert.assertEquals(Integer.valueOf(24000), Day01.part1(baseFilePath));
    }

    @Test
    private static void part2Test()
    {
        Assert.assertEquals(Integer.valueOf(45000), Day01.part2(baseFilePath));
    }

}
