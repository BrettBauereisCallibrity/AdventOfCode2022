package main.java.days;

import main.java.Input;

import java.util.ArrayList;

public class Day04 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 4 - Part 1: " + part1(filePathBase));
        System.out.println("Day 4 - Part 2: " + part2(filePathBase));
    }

    public static Integer part1(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day04.txt");
        int count = 0;

        for (String line : lines)
        {
           String[] splits = line.split(",");

           Integer i1 = Integer.parseInt(splits[0].split("-")[0]);
           Integer j1 = Integer.parseInt(splits[0].split("-")[1]);
           Integer i2 = Integer.parseInt(splits[1].split("-")[0]);
           Integer j2 = Integer.parseInt(splits[1].split("-")[1]);

           if (i1 <= i2 && j1 >= j2 || i1 >= i2 && j1 <= j2)
           {
               count++;
           }
        }
        return count;

    }

    public static Integer part2(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day04.txt");
        int count = 0;

        for (String line : lines)
        {
            String[] splits = line.split(",");

            Integer i1 = Integer.parseInt(splits[0].split("-")[0]);
            Integer j1 = Integer.parseInt(splits[0].split("-")[1]);
            Integer i2 = Integer.parseInt(splits[1].split("-")[0]);
            Integer j2 = Integer.parseInt(splits[1].split("-")[1]);

            if (i1 < i2 && j1 >= i2 || i1 > i2 && j2 >= i1)
            {
                count++;
            }
            else if (i1 == i2 || i1 == j2 || j1 == i2 || j1 == j2)
            {
                count++;
            }
        }
        return count;
    }

}
