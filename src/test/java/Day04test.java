package test.java;

import main.java.Input;
import main.java.days.Day04;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day04test {

    @Test
    private static void part1Test()
    {
        Assert.assertEquals(Day04.part1(Input.testFileBasePath), Integer.valueOf(2));
    }

    @Test
    private static void part2Test()
    {
        Assert.assertEquals(Day04.part2(Input.testFileBasePath), Integer.valueOf(4));
    }
}
