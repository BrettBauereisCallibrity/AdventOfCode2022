package test.java.days;

import main.java.Input;
import main.java.days.Day02;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day02Test {

    @Test
    private static void part1Test()
    {
        Assert.assertEquals(Day02.part1(Input.testFileBasePath), Integer.valueOf(15));
    }

    @Test
    private static void part2Test()
    {
        Assert.assertEquals(Day02.part2(Input.testFileBasePath), Integer.valueOf(12));
    }

}
