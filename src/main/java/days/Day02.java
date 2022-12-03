package main.java.days;

import main.java.Input;

import java.util.ArrayList;

public class Day02 {

    public static void showMeTheMoney(String filePathBase) {
        System.out.println("Day 2 - Part 1: " + part1(filePathBase));
        System.out.println("Day 2 - Part 2: " + part2(filePathBase));
    }

    private static char rock = '1';
    private static char paper = '2';
    private static char scissors = '3';
    private static char win = '6';
    private static char tie = '3';
    private static char loss = '0';

    public static Integer part1(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day02.txt");
        ArrayList<ScoreTemplate> scoreTemplates = new ArrayList<>();
        scoreTemplates.add(new ScoreTemplate('X', rock, tie, loss, win));
        scoreTemplates.add(new ScoreTemplate('Y', paper, win, tie, loss));
        scoreTemplates.add(new ScoreTemplate('Z', scissors, loss, win, tie));

        return getTheScore(lines, scoreTemplates);
    }

    public static Integer part2(String filePathBase)
    {
        ArrayList<String> lines = Input.readAsLines(filePathBase, "Day02.txt");
        ArrayList<ScoreTemplate> scoreTemplates = new ArrayList<>();
        scoreTemplates.add(new ScoreTemplate('X', loss, scissors, rock, paper));
        scoreTemplates.add(new ScoreTemplate('Y', tie, rock, paper, scissors));
        scoreTemplates.add(new ScoreTemplate('Z', win, paper, scissors, rock));

        return getTheScore(lines, scoreTemplates);
    }

    public static Integer getTheScore(ArrayList<String> lines, ArrayList<ScoreTemplate> scoreTemplates)
    {
        Integer score = 0;
        for (String line : lines) {
            String[] scoresAsChars = convertLettersToScores(line, scoreTemplates).split(" ");
            score += (Integer.parseInt(scoresAsChars[0]));
            score += (Integer.parseInt(scoresAsChars[1]));
        }
        return score;
    }

    public static String convertLettersToScores(String line, ArrayList<ScoreTemplate> scoreTemplates)
    {
        for (ScoreTemplate template : scoreTemplates)
        {
            if (line.contains(String.valueOf(template.getXyz())))
            {
                return line.replace(template.getXyz(), template.getXyzMeans())
                            .replace('A', template.getAMeans())
                            .replace('B', template.getBMeans())
                            .replace('C', template.getCMeans());
            }
        }
        return line;
    }

    public static class ScoreTemplate {
        private char xyz;
        private char xyzMeans;
        private char aMeans;
        private char bMeans;
        private char cMeans;

        public ScoreTemplate(char xyz, char xyzMeans, char aMeans, char bMeans, char cMeans)
        {
            this.xyz = xyz;
            this.xyzMeans = xyzMeans;
            this.aMeans = aMeans;
            this.bMeans = bMeans;
            this.cMeans = cMeans;
        }

        public char getXyz()
        {
            return xyz;
        }

        public char getXyzMeans()
        {
            return xyzMeans;
        }

        public char getAMeans()
        {
            return aMeans;
        }

        public char getBMeans()
        {
            return bMeans;
        }

        public char getCMeans()
        {
            return cMeans;
        }
    }

}
