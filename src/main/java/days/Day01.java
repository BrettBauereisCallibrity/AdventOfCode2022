package main.java.days;

import main.java.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 1 - Part 1: " + part1(filePathBase));
        System.out.println("Day 1 - Part 2: " + part2(filePathBase));
    }

    public static Integer part1(String filePathBase)
    {
        return Collections.max(calculateElfTotals(filePathBase));
    }

    public static Integer part2(String filePathBase)
    {
        ArrayList<Integer> elfTotals = calculateElfTotals(filePathBase);
        Collections.sort(elfTotals);
        List<Integer> top3 = elfTotals.subList(elfTotals.size()-3, elfTotals.size());
        return top3.stream().mapToInt(Integer::intValue).sum();
    }

    private static ArrayList<Integer> calculateElfTotals(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day01.txt");
        ArrayList<Integer> elfTotals = new ArrayList<>();
        Integer currentSum = 0;

        for (int i = 0 ; i < lines.size() ; i++)
        {
            if (lines.get(i).isEmpty())
            {
                elfTotals.add(currentSum);
                currentSum = 0;
            }
            else
            {
                currentSum += Integer.parseInt(lines.get(i));
            }
        }
        elfTotals.add(currentSum);

        return elfTotals;
    }

}
