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
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day06.txt");
        ArrayList<Character> allOfEm = Utils.convertStringToArraylistOfCharacters(lines.get(0));

        for (int i = 3; i < allOfEm.size(); i++)
        {
            ArrayList<Character> fourInARow = new ArrayList<Character>();

            for (int n = 0; n <= 3; n++){
                fourInARow.add(allOfEm.get(i-n));
            }

            HashSet<Character> hashed = new HashSet<Character>(fourInARow);

            if (hashed.size() == 4)
            {
                return i+1;
            }
        }

        return 0;
    }

    public static Integer part2(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day06.txt");
        ArrayList<Character> allOfEm = Utils.convertStringToArraylistOfCharacters(lines.get(0));

        for (int i = 13; i < allOfEm.size(); i++)
        {
            ArrayList<Character> fourInARow = new ArrayList<Character>();

            for (int n = 0; n <= 13; n++){
                fourInARow.add(allOfEm.get(i-n));
            }

            HashSet<Character> hashed = new HashSet<Character>(fourInARow);

            if (hashed.size() == 14)
            {
                return i+1;
            }
        }
        return 0;
    }

}
