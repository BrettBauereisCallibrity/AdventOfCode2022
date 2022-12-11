package main.java.days;

import main.java.Input;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Day09 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 9 - Part 1: " + part1(filePathBase));
        System.out.println("Day 9 - Part 2: " + part2(filePathBase));
    }

    public static Integer part1(String filePathBase) {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day09.txt");
        return calculateUniquePositionsOfTailForNumberOfKnots(lines, 1);
    }

    public static Integer part2(String filePathBase) {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day09.txt");
        return calculateUniquePositionsOfTailForNumberOfKnots(lines, 9);
    }

    public static Integer calculateUniquePositionsOfTailForNumberOfKnots(ArrayList<String> lines, Integer numberOfKnotsAfterHead)
    {
        ArrayList<Coordinate> currentKnotCoordinates = createBeginningCoordinatesList(numberOfKnotsAfterHead);

        List<String> positionsTailHasBeen = new ArrayList<>();
        positionsTailHasBeen.add(currentKnotCoordinates.get(numberOfKnotsAfterHead).getX() + "," + currentKnotCoordinates.get(numberOfKnotsAfterHead).getY());

        for (String instruction : lines)
        {
            String[] splitInstructions = instruction.split(" ");
            String direction = splitInstructions[0];
            Integer distance = Integer.parseInt(splitInstructions[1]);

            for (int i = 1; i <= distance; i++) {
                switch(direction) {
                    case "R":
                        currentKnotCoordinates.get(0).increaseX();
                        break;
                    case "L":
                        currentKnotCoordinates.get(0).decreaseX();;
                        break;
                    case "U":
                        currentKnotCoordinates.get(0).increaseY();
                        break;
                    case "D":
                        currentKnotCoordinates.get(0).decreaseY();
                        break;
                    default:
                }
                for (int knot = 1; knot <= numberOfKnotsAfterHead ; knot++)
                {
                    Coordinate knotBefore = currentKnotCoordinates.get(knot-1);
                    Coordinate knotAfter = currentKnotCoordinates.get(knot);

                    if (!isHeadOneUnitAwayFromTailOrLess(knotBefore.getX(), knotBefore.getY(), knotAfter.getX(), knotAfter.getY()))
                    {
                        moveTheKnot(knotBefore, knotAfter);
                        if (knot == numberOfKnotsAfterHead)
                        {
                            positionsTailHasBeen.add(knotAfter.getX() + "," + knotAfter.getY());
                        }
                    }
                }
            }
        }
        HashSet<String> uniquePositionsTailHasBeen = new HashSet<>(positionsTailHasBeen);
        return uniquePositionsTailHasBeen.size();
    }

    public static void moveTheKnot(Coordinate knotBefore, Coordinate knotAfter)
    {
        Integer dx = knotBefore.getX() - knotAfter.getX();
        Integer dy = knotBefore.getY() - knotAfter.getY();
        if (dx > 0) knotAfter.increaseX();
        if (dx < 0) knotAfter.decreaseX();
        if (dy > 0) knotAfter.increaseY();
        if (dy < 0) knotAfter.decreaseY();
    }

    public static boolean isHeadOneUnitAwayFromTailOrLess(Integer headX, Integer headY, Integer tailX, Integer tailY)
    {
        return (Math.abs(headX - tailX) <= 1) && (Math.abs(headY - tailY) <= 1);
    }

    public static ArrayList<Coordinate> createBeginningCoordinatesList(Integer numberOfKnotsAfterHead)
    {
        ArrayList<Coordinate> knotPositions = new ArrayList<>();
        for (int i = 0; i <= numberOfKnotsAfterHead; i++) {
            knotPositions.add(new Coordinate(0,0));
        }
        return knotPositions;
    }

    public static class Coordinate {
        Integer x;
        Integer y;
        public Coordinate(Integer x, Integer y)
        {
            this.x = x;
            this.y = y;
        }

        public Integer getX() { return this.x;}
        public Integer getY() { return this.y;}
        public void setX(Integer x) { this.x = x;}
        public void setY(Integer y) { this.y = y;}
        public void increaseX() { this.x++;}
        public void increaseY() { this.y++;}
        public void decreaseX() { this.x--;}
        public void decreaseY() { this.y--;}
    }

}
