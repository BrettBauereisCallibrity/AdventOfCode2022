package main.java;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Character> convertStringToArraylistOfCharacters(String string)
    {
        ArrayList<Character> alChars = new ArrayList<>();
        for (char c : string.toCharArray()) {
            alChars.add(c);
        }
        return alChars;
    }

    public static ArrayList<Integer> convertStringToArraylistOfIntegers(String string)
    {
        ArrayList<Integer> nums = new ArrayList<>();
        for (char c : string.toCharArray()) {
            nums.add(Integer.parseInt(String.valueOf(c)));
        }
        return nums;
    }

}
