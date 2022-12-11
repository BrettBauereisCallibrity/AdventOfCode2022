package main.java.days;

import main.java.Input;

import java.util.ArrayList;

public class Day10 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 10 - Part 1: " + part1(filePathBase));
        part2(filePathBase);
        //System.out.println("Day 10 - Part 2: " + part2(filePathBase));
    }

    public static Integer part1(String filePathBase)
    {
        Integer xRegistrar = 1;
        Integer currentLine = 0;
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day10.txt");
        ArrayList<Integer> signalStrengths = new ArrayList<>();

        for (int cycle = 1; cycle<=220 ; cycle+=0)
        {
            String line = lines.get(currentLine);
            if (line.contains("noop")) {
                cycle++;
                addSignalStrengthIfNeeded(cycle, xRegistrar, signalStrengths);
            }
            else {
                cycle++;
                addSignalStrengthIfNeeded(cycle, xRegistrar, signalStrengths);
                cycle++;
                xRegistrar += Integer.parseInt(line.split(" ")[1]);
                addSignalStrengthIfNeeded(cycle, xRegistrar, signalStrengths);
            }
            currentLine++;
        }

        return signalStrengths.stream().mapToInt(Integer::intValue).sum();
    }

    public static void part2(String filePathBase)
    {
        Integer xRegistrar = 1;
        Integer currentLine = 0;
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day10.txt");
        String cycleCharacters = "";

        for (int cycle = 0; cycle<=239 ; cycle+=0)
        {
            String line = lines.get(currentLine);
            if (line.contains("noop")) {
                cycleCharacters += getCycleCharacter(xRegistrar, cycle);
                cycle++;
            }
            else {
                cycleCharacters += getCycleCharacter(xRegistrar, cycle);
                cycle++;
                cycleCharacters += getCycleCharacter(xRegistrar, cycle);
                cycle++;
                xRegistrar += Integer.parseInt(line.split(" ")[1]);
            }
            currentLine++;
        }

        System.out.println(cycleCharacters.substring(0,40));
        System.out.println(cycleCharacters.substring(40,80));
        System.out.println(cycleCharacters.substring(80,120));
        System.out.println(cycleCharacters.substring(120,160));
        System.out.println(cycleCharacters.substring(160,200));
        System.out.println(cycleCharacters.substring(200));

    }

    public static void addSignalStrengthIfNeeded(Integer cycle, Integer xRegistrar, ArrayList<Integer> signalStrengths)
    {
        if ((cycle - 20) % 40 == 0)
        {
            signalStrengths.add(cycle * (xRegistrar));
        }
    }

    public static String getCycleCharacter(Integer xRegistrar, Integer cycle)
    {
        xRegistrar += ((cycle+1)/40 )*40;


        if (Math.abs(xRegistrar - cycle) <= 1)
        {
            return "#";
        }
        else
        {
            return ".";
        }
    }
    
}
