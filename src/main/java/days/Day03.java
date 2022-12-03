package main.java.days;

import main.java.Input;
import main.java.Utils;
import java.util.ArrayList;
import java.util.List;

public class Day03 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 3 - Part 1: " + part1(filePathBase));
        System.out.println("Day 3 - Part 2: " + part2(filePathBase));
    }

    public static Integer part1(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day03.txt");
        Integer scores = 0;

        for (String line : lines)
        {
            ArrayList<Character> firstHalf = Utils.convertStringToArraylistOfCharacters(line.substring(0, line.length() / 2));
            ArrayList<Character> secondHalf = Utils.convertStringToArraylistOfCharacters(line.substring(line.length() / 2));
            firstHalf.retainAll(secondHalf);

            scores += convertCharToValue(firstHalf.get(0));
        }
        return scores;
    }

    public static Integer part2(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day03.txt");
        Integer scores = 0;

        for (int i = 0 ; i < lines.size() ;  i = i + 3)
        {
            List<Character> common = Utils.convertStringToArraylistOfCharacters(lines.get(i));
            common.retainAll(Utils.convertStringToArraylistOfCharacters(lines.get(i+1)));
            common.retainAll(Utils.convertStringToArraylistOfCharacters(lines.get(i+2)));

            scores += convertCharToValue(common.get(0));
        }
        return scores;
    }

    private static Integer convertCharToValue(Character letter)
    {
        return Character.isUpperCase(letter) ? (int) letter - 38 : (int) letter - 96;
    }
}
