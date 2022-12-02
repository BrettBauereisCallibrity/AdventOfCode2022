package main.java.days;

import main.java.Input;

import java.util.ArrayList;

public class Day02 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 2 - Part 1: " + part1(filePathBase));
        System.out.println("Day 2 - Part 2: " + part2(filePathBase));
    }

    public static Integer part1(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day02.txt");
        ArrayList<char[]> scoreTemplates = new ArrayList<>();
        scoreTemplates.add(new char[]{'X','1', '3', '0', '6'});
        scoreTemplates.add(new char[]{'Y','2', '6', '3', '0'});
        scoreTemplates.add(new char[]{'Z','3', '0', '6', '3'});

        return getTheScore(lines, scoreTemplates);
    }

    public static Integer part2(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day02.txt");
        ArrayList<char[]> scoreTemplates = new ArrayList<>();
        scoreTemplates.add(new char[]{'Z','6', '2', '3', '1'});
        scoreTemplates.add(new char[]{'Y','3', '1', '2', '3'});
        scoreTemplates.add(new char[]{'X','0', '3', '1', '2'});

        return getTheScore(lines, scoreTemplates);
    }

    public static Integer getTheScore(ArrayList<String> lines, ArrayList<char[]> scoreTemplates)
    {
        ArrayList<String> newLines = new ArrayList<>();
        for (String line : lines) {
            newLines.add(convertValues(line, scoreTemplates));
        }

        ArrayList<Integer> points = new ArrayList<>();
        for (String line : newLines) {
            String[] splits = line.split(" ");
            points.add(Integer.parseInt(splits[0]));
            points.add(Integer.parseInt(splits[1]));
        }

        return points.stream().mapToInt(Integer::intValue).sum();
    }

    public static String convertValues(String line, ArrayList<char[]> scoreTemplates)
    {
        for (char[] template : scoreTemplates)
        {
            if (line.contains(String.valueOf(template[0])))
            {
                line = lineReplace(line, template);
            }
        }
        return line;
    }

    public static String lineReplace(String line, char[] chars)
    {
        line = line.replace(chars[0], chars[1]).replace('A', chars[2]).replace('B', chars[3]).replace('C', chars[4]);
        return line;
    }

}
