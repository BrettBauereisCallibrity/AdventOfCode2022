package test.java;

import main.java.Input;
import main.java.days.Day09;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day09Test {

    @Test
    private static void part1Test()
    {
        Assert.assertEquals(Day09.part1(Input.testFileBasePath), Integer.valueOf(13));
    }

    @Test
    private static void part2Test()
    {
        Assert.assertEquals(Day09.part2(Input.testFileBasePath), Integer.valueOf(36));
    }
}
