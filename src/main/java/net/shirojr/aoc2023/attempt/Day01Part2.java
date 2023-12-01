package net.shirojr.aoc2023.attempt;

import net.shirojr.aoc2023.Main;
import net.shirojr.aoc2023.util.DayComponent;
import net.shirojr.aoc2023.util.FileHelper;

import java.util.*;
import java.util.stream.Stream;

public class Day01Part2 implements DayComponent {
    private final FileHelper.Task task = FileHelper.getPlainTextData("day01_part2.txt");
    private final DayComponent day01;

    public Day01Part2(DayComponent dayComponent) {
        this.day01 = dayComponent;
    }

    @Override
    public String getDay() {
        return task.dayAndPart();
    }

    @Override
    public List<String> getProblem() {
        return task.problemLines();
    }

    @Override
    public String getSolution() {
        List<String> unprocessedLines = day01.getDataSetFromFile();

        int sum = 0;
        for (String line : unprocessedLines) {
            int value = Integer.parseInt(getFirstAndLastDigitFromLine(line));
            sum += value;
        }
        return String.valueOf(sum);
    }

    private static Map<String, Integer> numberMapping() {
        Map<String, Integer> numberMapping = new HashMap<>();
        numberMapping.put("zero", 0);
        numberMapping.put("one", 1);
        numberMapping.put("two", 2);
        numberMapping.put("three", 3);
        numberMapping.put("four", 4);
        numberMapping.put("five", 5);
        numberMapping.put("six", 6);
        numberMapping.put("seven", 7);
        numberMapping.put("eight", 8);
        numberMapping.put("nine", 9);
        return numberMapping;
    }

    private static String getFirstAndLastDigitFromLine(String input) {
        input = input.toLowerCase();
        String digits = input.replaceAll("[a-z]", "");

        if (digits.length() < 1) {
            Pair first = Pair.getAlphabeticalFirst(input);
            Pair last = Pair.getAlphabeticalLast(input);
            return String.valueOf(first.value) + last.value;
        }

        Pair first = new Pair(input.indexOf(digits.charAt(0)), Character.getNumericValue(digits.charAt(0)));
        Pair last = new Pair(input.lastIndexOf(digits.charAt(digits.length() - 1)), Character.getNumericValue(digits.charAt(digits.length() - 1)));

        for (var entry : numberMapping().entrySet()) {
            if (!input.contains(entry.getKey())) continue;

            if (input.indexOf(entry.getKey()) < first.index) {
                first = new Pair(input.indexOf(entry.getKey()), entry.getValue());
            }

            if (input.lastIndexOf(entry.getKey()) > last.index) {
                last = new Pair(input.lastIndexOf(entry.getKey()), entry.getValue());
            }
        }
        return String.valueOf(first.value) + last.value;
    }

    private record Pair(int index, int value) {
        public static Pair getAlphabeticalFirst(String line) {
            Pair tmpFirst = new Pair(Integer.MAX_VALUE, -1);

            for (var entry : numberMapping().entrySet()) {
                if (!line.contains(entry.getKey())) continue;
                if (line.indexOf(entry.getKey()) < tmpFirst.index) tmpFirst = new Pair(line.indexOf(entry.getKey()), entry.getValue());
            }
            return tmpFirst;
        }

        public static Pair getAlphabeticalLast(String line) {
            Pair tmpLast = new Pair(-1, -1);
            for (var entry : numberMapping().entrySet()) {
                if (!line.contains(entry.getKey())) continue;
                if (line.lastIndexOf(entry.getKey()) > tmpLast.index) tmpLast = new Pair(line.lastIndexOf(entry.getKey()), entry.getValue());
            }
            return tmpLast;
        }
    }
}
