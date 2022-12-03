package test.java.days;

import main.java.Input;
import main.java.days.Day03;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day03Test {

    @Test
    private static void part1Test()
    {
        Assert.assertEquals(Day03.part1(Input.testFileBasePath), Integer.valueOf(157));
    }

    @Test
    private static void part2Test()
    {
        Assert.assertEquals(Day03.part2(Input.testFileBasePath), Integer.valueOf(70));
    }
}
