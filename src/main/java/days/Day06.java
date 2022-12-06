package main.java.days;

import main.java.Input;
import main.java.Utils;

import java.util.ArrayList;
import java.util.HashSet;

public class Day06 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 6 - Part 1: " + part1(filePathBase));
        System.out.println("Day 6 - Part 2: " + part2(filePathBase));
    }

    public static Integer part1(String filePathBase)
    {
        return findUniqueCharsStringLengthX(4, filePathBase);
    }

    public static Integer part2(String filePathBase)
    {
        return findUniqueCharsStringLengthX(14, filePathBase);
    }

    private static Integer findUniqueCharsStringLengthX(Integer lengthOfUniqueString, String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day06.txt");
        ArrayList<Character> fileAsChars = Utils.convertStringToArraylistOfCharacters(lines.get(0));

        for (int i = lengthOfUniqueString - 1; i < fileAsChars.size(); i++)
        {
            ArrayList<Character> xInARow = new ArrayList<>();
            for (int n = 0; n <= lengthOfUniqueString - 1; n++){
                xInARow.add(fileAsChars.get(i-n));
            }

            HashSet<Character> hashed = new HashSet<>(xInARow);
            if (hashed.size() == lengthOfUniqueString)
            {
                return i+1;
            }
        }
        return 0;
    }
}
