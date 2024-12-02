package net.shirojr.aoc2024.attempt.day01;

import net.shirojr.common.util.DayComponent;
import net.shirojr.common.util.FileHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day01Part2 implements DayComponent {
    private final FileHelper.Task task;

    public Day01Part2(String filename) {
        task = FileHelper.getPlainTextData(filename);
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
        List<String> unprocessedLines = task.dataLines();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (String line : unprocessedLines) {
            left.add(Integer.valueOf(line.split(" {3}")[0]));
            right.add(Integer.valueOf(line.split(" {3}")[1]));
        }
        return String.valueOf(getSum(left, right));
    }

    private static int getSum(List<Integer> left, List<Integer> right) {
        HashMap<Integer, Integer> cachedCounter = new HashMap<>();
        int sum = 0;

        for (int leftEntry : left) {
            if (!cachedCounter.containsKey(leftEntry)) {
                int sameNumbers = 0;
                for (int rightEntry : right) {
                    if (leftEntry == rightEntry) sameNumbers++;
                }
                cachedCounter.put(leftEntry, sameNumbers);
            }
        }
        for (var entry : left) {
            sum += entry * cachedCounter.get(entry);
        }
        return sum;
    }
}
