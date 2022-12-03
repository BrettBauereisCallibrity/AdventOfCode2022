package main.java.days;

import main.java.Input;

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
            int mid = line.length() / 2;
            String[] parts = {line.substring(0, mid), line.substring(mid)};

            ArrayList<Character> firstHalf = convertStringToArraylistChars(parts[0]);
            ArrayList<Character> secondHalf = convertStringToArraylistChars(parts[1]);

            List<Character> common = new ArrayList<Character>(firstHalf);
            common.retainAll(secondHalf);

            scores += convertCharToValue(common.get(0));
        }

        return scores;
    }

    public static Integer part2(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day03.txt");
        Integer scores = 0;
        for (int i = 0 ; i < lines.size() ;  i = i + 3)
        {
            ArrayList<Character> firstGroup = convertStringToArraylistChars(lines.get(i));
            ArrayList<Character> secondGroup = convertStringToArraylistChars(lines.get(i+1));
            ArrayList<Character> thirdGroup = convertStringToArraylistChars(lines.get(i+2));

            List<Character> common = new ArrayList<Character>(firstGroup);
            common.retainAll(secondGroup);
            common.retainAll(thirdGroup);

            scores += convertCharToValue(common.get(0));
        }

        return scores;
    }

    private static ArrayList<Character> convertStringToArraylistChars(String string)
    {
        ArrayList<Character> alChars = new ArrayList<Character>();
        for (char c : string.toCharArray()) {
            alChars.add(c);
        }
        return alChars;
    }

    private static Integer convertCharToValue(Character letter)
    {
        int castAscii = (int) letter;
        if (castAscii < 91 )
        {
            return castAscii - 38;
        }
        else
        {
            return castAscii - 96;
        }
    }
}
