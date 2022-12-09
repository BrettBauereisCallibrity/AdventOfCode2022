package test.java;

import main.java.Input;
import main.java.days.Day07;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day07Test {

    @Test
    private static void part1Test()
    {
        Assert.assertEquals(Day07.part1(Input.testFileBasePath), Integer.valueOf(95437));
    }

    @Test
    private static void part2Test()
    {
        Assert.assertEquals(Day07.part2(Input.testFileBasePath), Integer.valueOf(24933642));
    }
}
