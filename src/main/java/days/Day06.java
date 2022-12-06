package main.java.days;

import main.java.Input;
import main.java.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day06 {
    
    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 6 - Part 1: " + part1(filePathBase));
        System.out.println("Day 6 - Part 2: " + part2(filePathBase));
    }

    public static Integer part1(String filePathBase)
    {
        return findPositionOfUniqueCharStringOfLengthX(4, filePathBase);
    }

    public static Integer part2(String filePathBase)
    {
        return findPositionOfUniqueCharStringOfLengthX(14, filePathBase);
    }

    private static Integer findPositionOfUniqueCharStringOfLengthX(Integer lengthOfUniqueString, String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day06.txt");
        ArrayList<Character> allCharsFromFile = Utils.convertStringToArraylistOfCharacters(lines.get(0));

        for (int i = lengthOfUniqueString; i < allCharsFromFile.size(); i++)
        {
            List<Character> xInARow = allCharsFromFile.subList(i-lengthOfUniqueString, i);
            if (xInARow.size() == new HashSet<>(xInARow).size())
            {
                return i;
            }
        }
        return 0;
    }
}
