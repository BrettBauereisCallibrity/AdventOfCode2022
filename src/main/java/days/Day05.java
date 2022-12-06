package main.java.days;

import main.java.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day05 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 5 - Part 1: " + part1(filePathBase));
        System.out.println("Day 5 - Part 2: " + part2(filePathBase));
    }

    public static String part1(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day05.txt");
        int lastLineOfBlocks = findLastLineOfBlocks(lines);
        int numberOfColumns = getNumberOfColumns(lines, lastLineOfBlocks);
        List<List<Character>> columns = createColumns(lastLineOfBlocks, numberOfColumns, lines);
        sortColumnsBasedOnInstructions(columns, lines, true);
        return getStringFromColumns(columns);
    }

    public static String part2(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day05.txt");
        int lastLineOfBlocks = findLastLineOfBlocks(lines);
        int numberOfColumns = getNumberOfColumns(lines, lastLineOfBlocks);
        List<List<Character>> columns = createColumns(lastLineOfBlocks, numberOfColumns, lines);
        sortColumnsBasedOnInstructions(columns, lines, false);
        return getStringFromColumns(columns);
    }


    private static int findLastLineOfBlocks(ArrayList<String> lines)
    {
        return lines.indexOf("") - 2;
    }

    private static int getNumberOfColumns(ArrayList<String> lines, int lastLineOfBlocks)
    {
        return (lines.get(lastLineOfBlocks).length() + 1)/4;
    }

    private static List<List<Character>> createColumns(int lastLineOfBlocks, int numberOfColumns, ArrayList<String> lines)
    {
        List<List<Character>> columns = new ArrayList<>();
        for (int i = 0 ; i < numberOfColumns; i++)
        {
            columns.add(new ArrayList<Character>());
        }
        populateColumns(lastLineOfBlocks, numberOfColumns, lines, columns);
        return columns;
    }

    private static void populateColumns(int lastLineOfBlocks, int numberOfColumns, ArrayList<String> lines, List<List<Character>> columns)
    {
        for(int i = lastLineOfBlocks; i >= 0; i--)
        {
            addColumnValuesFromLine(numberOfColumns, lines.get(i), columns);
        }
        for (List<Character> column : columns)
        {
            column.removeAll(Arrays.asList(' '));
        }
    }

    private static void addColumnValuesFromLine(int numberOfColumns, String line, List<List<Character>> columns)
    {
        for (int n = 1; n < numberOfColumns*4; n = n +4){
            int currentColumn = (n-1)/4;
            try
            {
                columns.get(currentColumn).add(line.charAt(n));
            }
            catch (Exception e) {}
        }
    }

    private static void sortColumnsBasedOnInstructions(List<List<Character>> columns, ArrayList<String> lines, boolean part1)
    {
        for (String line : lines )
        {
            if (line.contains("move") && part1)
            {
                handleMovePart1(columns, line);
            }
            else if (line.contains("move") && !part1)
            {
                handleMovePart2(columns, line);
            }
        }
    }

    private static void handleMovePart1(List<List<Character>> columns, String line)
    {
        String[] splits = line.split(" ");

        //move 1 from 2 to 1
        //e.g. MoveValues = {1, 1, 0} {amount, columnIndexFrom, columnIndexTo
        Integer[] moveValues = {Integer.parseInt(splits[1]), Integer.parseInt(splits[3])-1, Integer.parseInt(splits[5])-1};
        for (int i = 0; i < moveValues[0]; i++)
        {
            columns.get(moveValues[2]).add(columns.get(moveValues[1]).get(columns.get(moveValues[1]).size()-1));
            columns.get(moveValues[1]).remove(columns.get(moveValues[1]).size()-1);
        }
    }

    private static void handleMovePart2(List<List<Character>> columns, String line)
    {
        String[] splits = line.split(" ");
        Integer[] moveValues = {Integer.parseInt(splits[1]), Integer.parseInt(splits[3])-1, Integer.parseInt(splits[5])-1};

        Character[] movedBoxes = new Character[moveValues[0]];

        for (int i = 0; i < moveValues[0]; i++)
        {
            movedBoxes[i] = columns.get(moveValues[1]).get(columns.get(moveValues[1]).size()-1);
            columns.get(moveValues[1]).remove(columns.get(moveValues[1]).size()-1);
        }
        for (int i = moveValues[0] - 1 ; i >=0 ; i--)
        {
            columns.get(moveValues[2]).add(movedBoxes[i]);
        }
    }

    private static String getStringFromColumns(List<List<Character>> columns)
    {
        String topOfBoxes = "";
        for (List<Character> column : columns)
        {
            topOfBoxes += column.get(column.size()-1);
        }
        return topOfBoxes;
    }
}
