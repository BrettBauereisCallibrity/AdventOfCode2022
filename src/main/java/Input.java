package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Input {

    public static ArrayList<String> getFileRowsAsArrayOfStrings(String filePathBase, String fileName) {
        String fullFilePath = filePathBase + fileName;
        BufferedReader reader;
        ArrayList<String> lines = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(fullFilePath));
            String line = reader.readLine();

            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }
}
