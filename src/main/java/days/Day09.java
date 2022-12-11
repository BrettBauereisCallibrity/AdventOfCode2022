package main.java.days;

import main.java.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Day09 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 9 - Part 1: " + part1(filePathBase));
        System.out.println("Day 9 - Part 2: " + part2(filePathBase));
    }

    public static Integer part1(String filePathBase) {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day09.txt");
        Integer[] coordinatesOfHead = {0,0};
        Integer[] coordinatesOfTail = {0,0};

        List<String> positionsTailHasBeen = new ArrayList<>();
        positionsTailHasBeen.add(coordinatesOfTail[0] + "," + coordinatesOfTail[1]);
        for (String instruction : lines)
        {
            String[] splitInstructions = instruction.split(" ");
            String direction = splitInstructions[0];
            Integer distance = Integer.parseInt(splitInstructions[1]);

            for (int i = 1; i <= distance; i++) {
                switch(direction) {
                    case "R":
                        coordinatesOfHead[0]++;
                        break;
                    case "L":
                        coordinatesOfHead[0]--;
                        break;
                    case "U":
                        coordinatesOfHead[1]++;
                        break;
                    case "D":
                        coordinatesOfHead[1]--;
                        break;
                    default:
                }
                if (!isHeadOneUnitAwayFromTailOrLess(coordinatesOfHead[0], coordinatesOfHead[1], coordinatesOfTail[0], coordinatesOfTail[1]))
                {
                    Integer dx = coordinatesOfHead[0] - coordinatesOfTail[0];
                    Integer dy = coordinatesOfHead[1] - coordinatesOfTail[1];

                    if (dx != 0)
                    {
                        coordinatesOfTail[0] = dx > 0 ? coordinatesOfTail[0] + 1 : coordinatesOfTail[0] - 1;
                    }
                    if (dy != 0)
                    {
                        coordinatesOfTail[1] = dy > 0 ? coordinatesOfTail[1] + 1 : coordinatesOfTail[1] - 1;
                    }
                    positionsTailHasBeen.add(coordinatesOfTail[0] + "," + coordinatesOfTail[1]);
                }
            }
        }
        HashSet<String> uniquePositionsTailHasBeen = new HashSet<>(positionsTailHasBeen);
        return uniquePositionsTailHasBeen.size();
    }

    public static Integer part2(String filePathBase) {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day09.txt");
        return 5;
    }

    public static boolean isHeadOneUnitAwayFromTailOrLess(Integer headX, Integer headY, Integer tailX, Integer tailY)
    {
        return (Math.abs(headX - tailX) <= 1) && (Math.abs(headY - tailY) <= 1);
    }
}
