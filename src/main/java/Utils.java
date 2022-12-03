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

}
