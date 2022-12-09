package main.java.days;

import main.java.Input;
import main.java.Utils;

import java.util.ArrayList;
import java.util.Collections;

public class Day08 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 8 - Part 1: " + part1(filePathBase));
        System.out.println("Day 8 - Part 2: " + part2(filePathBase));
    }

    public static Integer part1(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day08.txt");
        ArrayList<ArrayList<Integer>> rowsOfTreeHeights = getRowsOfTreeHeights(lines);

        ArrayList<Tree> allTreesNotOnEdge = getAllOfTheTreesNotOnEdge(rowsOfTreeHeights);

        Integer lengthOfARowOfTrees = rowsOfTreeHeights.get(0).size();
        Integer heightOfAColumnOfTrees = rowsOfTreeHeights.size();
        Integer visibleTrees = calculateNumberOfOutsideEdgeTrees(lengthOfARowOfTrees, heightOfAColumnOfTrees);

        for (Tree tree : allTreesNotOnEdge) {
            if (tree.isVisible()) {
                visibleTrees++;
            }
        }

        return visibleTrees;
    }

    public static Integer part2(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day08.txt");
        ArrayList<ArrayList<Integer>> rowsOfTreeHeights = getRowsOfTreeHeights(lines);
        ArrayList<Tree> allTreesInside = getAllOfTheTreesNotOnEdge(rowsOfTreeHeights);

        ArrayList<Integer> scenicScores = new ArrayList<>();
        for (Tree tree : allTreesInside) {
            scenicScores.add(tree.calculateScenicScore());
        }

        return Collections.max(scenicScores);
    }

    public static class Tree
    {
        Integer height;
        ArrayList<Integer> rowOfTreesToLeft;
        ArrayList<Integer> rowOfTreesToRight;
        ArrayList<Integer> columnOfTreesAbove;
        ArrayList<Integer> columnOfTreesBelow;

        public Tree(Integer height) {
            this.height = height;
        }

        public void setRowOfTreesToLeft(ArrayList<Integer> rowOfTreesToLeft)
        {
            this.rowOfTreesToLeft = rowOfTreesToLeft;
        }

        public void setRowOfTreesToRight(ArrayList<Integer> rowOfTreesToRight)
        {
            this.rowOfTreesToRight = rowOfTreesToRight;
        }

        public void setColumnOfTreesAbove(ArrayList<Integer> columnOfTreesAbove)
        {
            this.columnOfTreesAbove = columnOfTreesAbove;
        }
        public void setColumnOfTreesBelow(ArrayList<Integer> columnOfTreesBelow)
        {
            this.columnOfTreesBelow = columnOfTreesBelow;
        }

        public boolean isVisible()
        {
            if (isTallestTreeInTheList(rowOfTreesToLeft, height) ||
                isTallestTreeInTheList(rowOfTreesToRight, height) ||
                isTallestTreeInTheList(columnOfTreesAbove, height) ||
                isTallestTreeInTheList(columnOfTreesBelow, height))
            {
                return true;
            }
            return false;
        }

        public Integer calculateScenicScore()
        {
            Collections.reverse(rowOfTreesToLeft);
            Collections.reverse(columnOfTreesAbove);

            Integer scenicScore = howManyTreesCanBeSeen(rowOfTreesToLeft, height)
                                    * howManyTreesCanBeSeen(rowOfTreesToRight, height)
                                    * howManyTreesCanBeSeen(columnOfTreesAbove, height)
                                    * howManyTreesCanBeSeen(columnOfTreesBelow, height);

            return scenicScore;
        }
    }


    public static Integer howManyTreesCanBeSeen(ArrayList<Integer> treesBetweenEdge, Integer thisTreeHeight)
    {
        for (int i = 0 ; i < treesBetweenEdge.size(); i ++) {
            if (treesBetweenEdge.get(i) >= thisTreeHeight) {
                return i+1;
            }
        }
        return treesBetweenEdge.size();
    }

    public static boolean isTallestTreeInTheList(ArrayList<Integer> otherTreeHeights, Integer thisTreeHeight)
    {
        ArrayList<Integer> allTreeHeights = otherTreeHeights;
        allTreeHeights.add(thisTreeHeight);

        if (Collections.max(allTreeHeights) == thisTreeHeight && Collections.frequency(allTreeHeights, thisTreeHeight) == 1)
        {
            return true;
        }
        return false;
    }

    public static ArrayList<ArrayList<Integer>> getRowsOfTreeHeights(ArrayList<String> lines)
    {
        ArrayList<ArrayList<Integer>> rowsOfTreeHeights = new ArrayList<>();

        for (String line: lines)
        {
            rowsOfTreeHeights.add(Utils.convertStringToArraylistOfIntegers(line));
        }
        return rowsOfTreeHeights;
    }

    public static Integer calculateNumberOfOutsideEdgeTrees(Integer rowLength, Integer columnHeight)
    {
        return (rowLength -1 ) * 2 + (columnHeight-1) * 2;
    }

    public static ArrayList<Integer> createCurrentColumn(ArrayList<ArrayList<Integer>> allTreeRows, Integer currentRowPositionX)
    {
        ArrayList<Integer> column = new ArrayList<>();

        for (int i = 0 ; i <= allTreeRows.size() -1 ; i++){
            column.add(allTreeRows.get(i).get(currentRowPositionX));
        }
        return column;
    }

    public static ArrayList<Tree> getAllOfTheTreesNotOnEdge(ArrayList<ArrayList<Integer>> allTreeRows)
    {
        ArrayList<Tree> allTrees = new ArrayList<>();
        Integer lengthOfARow = allTreeRows.get(0).size();
        Integer heightOfAColumn = allTreeRows.size();

        for (int columnPositionY = 0 ; columnPositionY < allTreeRows.size() ; columnPositionY++)
        {
            for (int rowPositionX = 0; rowPositionX < heightOfAColumn-1 ; rowPositionX++)
            {
                if (columnPositionY != 0 && columnPositionY != (heightOfAColumn-1) && rowPositionX != 0 && rowPositionX != (lengthOfARow-1))
                {
                    Integer treeHeight = allTreeRows.get(columnPositionY).get(rowPositionX);
                    ArrayList<Integer> rowOfTreesToLeft = new ArrayList<>(allTreeRows.get(columnPositionY).subList(0,rowPositionX));
                    ArrayList<Integer> rowOfTreesToRight =new ArrayList<>(allTreeRows.get(columnPositionY).subList(rowPositionX+1,allTreeRows.get(columnPositionY).size()));

                    ArrayList<Integer> column = createCurrentColumn(allTreeRows, rowPositionX);
                    ArrayList<Integer> columnOfTreesAbove = new ArrayList<>(column.subList(0, columnPositionY));
                    ArrayList<Integer> columnOfTreesBelow = new ArrayList<>(column.subList(columnPositionY +1, column.size()));

                    Tree tree = new Tree(treeHeight);
                    tree.setRowOfTreesToLeft(rowOfTreesToLeft);
                    tree.setRowOfTreesToRight(rowOfTreesToRight);
                    tree.setColumnOfTreesAbove(columnOfTreesAbove);
                    tree.setColumnOfTreesBelow(columnOfTreesBelow);

                    allTrees.add(tree);
                }
            }
        }
        return allTrees;
    }

}
