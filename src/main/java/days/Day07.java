package main.java.days;

import main.java.Input;

import java.util.*;

public class Day07 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 7 - Part 1: " + part1(filePathBase));
        System.out.println("Day 7 - Part 2: " + part2(filePathBase));
    }

    public static Integer part1(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day07.txt");
        ArrayList<String> filePaths = getAllFilePaths(lines);
        Map<String, Integer> directories = calculateAllDirectoriesWithFileSizes(filePaths);

        return getSumOfDirectoriesUnder100000(directories);
    }

    public static Integer part2(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day07.txt");
        ArrayList<String> filePaths = getAllFilePaths(lines);
        Map<String, Integer> directories = calculateAllDirectoriesWithFileSizes(filePaths);

        Integer spaceNeeded = getSpaceNeeded(directories);

        List<Integer> directorySizes = new ArrayList<>(directories.values());
        Collections.sort(directorySizes);

        for (Integer directorySize : directorySizes) {
            if (directorySize > spaceNeeded) {
                return directorySize;
            }
        }
        return 0;
    }

    public static ArrayList<String> getAllFilePaths(ArrayList<String> lines)
    {
        ArrayList<String> filePaths = new ArrayList<>();
        String currentFilePath = "base";
        for (int i = 1; i < lines.size(); i++)
        {
            if (lines.get(i).contains("$ cd") && !lines.get(i).contains(".."))
            {
                String[] test = lines.get(i).split(" ");
                currentFilePath += "/" + test[test.length-1];
            }
            else if (lines.get(i).contains("$ cd") && lines.get(i).contains(".."))
            {
                try {
                    currentFilePath = currentFilePath.substring(0, currentFilePath.lastIndexOf("/"));
                }
                catch (Exception e){
                    currentFilePath = currentFilePath;
                }
            }
            else if (!lines.get(i).contains("$") && !lines.get(i).contains("dir"))
            {
                String[] test = lines.get(i).split(" ");
                filePaths.add(currentFilePath + "/" +  test[0]);
            }
        }
        return filePaths;
    }

    public static Map<String, Integer> calculateAllDirectoriesWithFileSizes(ArrayList<String> allFilePaths)
    {
        Map<String, Integer> directories = new HashMap<>();

        for (String filePath : allFilePaths)
        {
            String firstPart = filePath.substring(0, filePath.lastIndexOf("/"));
            String secondPart = filePath.substring( filePath.lastIndexOf("/") +1);

            String[] splits = firstPart.split("/");
            for (int i = 0; i < splits.length-1; i++)
            {
                addItToTheMap(directories, firstPart, Integer.parseInt(secondPart));
                firstPart = firstPart.substring(0, firstPart.lastIndexOf("/"));
            }
            addItToTheMap(directories, "base", Integer.parseInt(secondPart));
        }
        return directories;

    }

    public static void addItToTheMap(Map<String, Integer> directories, String directoryName, Integer filesSize)
    {
        if (directories.containsKey(directoryName))
        {
            directories.replace(directoryName, directories.get(directoryName) + filesSize);
        }
        else
        {
            directories.put(directoryName, filesSize);
        }

    }

    public static Integer getSumOfDirectoriesUnder100000(Map<String, Integer> directories)
    {
        Integer sum = 0;
        for (Map.Entry<String, Integer> directory: directories.entrySet())
        {
            if (directory.getValue() <= 100000){
                sum += directory.getValue();
            }
        }
        return sum;
    }

    public static Integer getSpaceNeeded(Map<String, Integer> directories)
    {
        Integer availableSpace = 70000000;
        Integer unusedSpaceNeeded = 30000000;
        return unusedSpaceNeeded - (availableSpace - directories.get("base"));

    }
}
