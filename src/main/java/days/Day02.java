package main.java.days;

import main.java.Input;

import java.util.ArrayList;

public class Day02 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 2 - Part 1: " + part1(filePathBase));
        System.out.println("Day 2 - Part 2: " + part2(filePathBase));
    }

    private static char rock = '1';
    private static char paper = '2';
    private static char scissors = '3';
    private static char win = '6';
    private static char tie = '3';
    private static char loss = '0';

    public static Integer part1(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day02.txt");
        ArrayList<char[]> scoreTemplates = new ArrayList<>();
        scoreTemplates.add(new char[]{'X', rock, tie, loss, win});
        scoreTemplates.add(new char[]{'Y', paper, win, tie, loss});
        scoreTemplates.add(new char[]{'Z', scissors, loss, win, tie});

        return getTheScore(lines, scoreTemplates);
    }

    public static Integer part2(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day02.txt");
        ArrayList<char[]> scoreTemplates = new ArrayList<>();
        scoreTemplates.add(new char[]{'X', loss, scissors, rock, paper});
        scoreTemplates.add(new char[]{'Y', tie, rock, paper, scissors});
        scoreTemplates.add(new char[]{'Z', win, paper, scissors, rock});

        return getTheScore(lines, scoreTemplates);
    }

    public static Integer getTheScore(ArrayList<String> lines, ArrayList<char[]> scoreTemplates)
    {
        ArrayList<String> newLines = new ArrayList<>();
        for (String line : lines) {
            newLines.add(convertLettersToScores(line, scoreTemplates));
        }

        ArrayList<Integer> scores = new ArrayList<>();
        for (String line : newLines) {
            String[] splits = line.split(" ");
            scores.add(Integer.parseInt(splits[0]));
            scores.add(Integer.parseInt(splits[1]));
        }

        return scores.stream().mapToInt(Integer::intValue).sum();
    }

    public static String convertLettersToScores(String line, ArrayList<char[]> scoreTemplates)
    {
        for (char[] template : scoreTemplates)
        {
            if (line.contains(String.valueOf(template[0])))
            {
                return line.replace(template[0], template[1]).replace('A', template[2]).replace('B', template[3]).replace('C', template[4]);
            }
        }

        return line;
    }

}
