package test.java;

import main.java.Input;
import main.java.days.Day09;
import main.java.days.Day10;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day10Test {

    @Test
    private static void part1Test()
    {
        Assert.assertEquals(Day10.part1(Input.testFileBasePath), Integer.valueOf(13140));
    }

    @Test
    private static void part2Test()
    {
        Day10.part2(Input.testFileBasePath);
        //Assert.assertEquals(Day10.part2(Input.testFileBasePath), Integer.valueOf(1));
    }
}
