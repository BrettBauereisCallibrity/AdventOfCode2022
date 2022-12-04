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

           String one = splits[0].split("-")[0];
           String two = splits[0].split("-")[1];
           String three = splits[1].split("-")[0];
           String four = splits[1].split("-")[1];

           if (Integer.parseInt(one) <= Integer.parseInt(three) && Integer.parseInt(two) >= Integer.parseInt(four) ||
                   Integer.parseInt(one) >= Integer.parseInt(three) && Integer.parseInt(two) <= Integer.parseInt(four))
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

            String one = splits[0].split("-")[0];
            String two = splits[0].split("-")[1];
            String three = splits[1].split("-")[0];
            String four = splits[1].split("-")[1];

            if (Integer.parseInt(one) < Integer.parseInt(three) && Integer.parseInt(two) >= Integer.parseInt(three))
            {
                count++;
            }
            else if (Integer.parseInt(one) > Integer.parseInt(three) && Integer.parseInt(four) >= Integer.parseInt(one))
            {
                count++;
            }
            else if (Integer.parseInt(one) == Integer.parseInt(three) || Integer.parseInt(one) == Integer.parseInt(four)
                    || Integer.parseInt(two) == Integer.parseInt(three) || Integer.parseInt(two) == Integer.parseInt(four))
            {
                count++;
            }
        }
        return count;
    }

}
