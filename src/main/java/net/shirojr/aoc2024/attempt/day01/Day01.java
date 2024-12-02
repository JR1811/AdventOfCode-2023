package net.shirojr.aoc2024.attempt.day01;

import net.shirojr.common.util.DayComponent;
import net.shirojr.common.util.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class Day01 implements DayComponent {
    private final FileHelper.Task task;

    public Day01(String filename) {
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

        left.sort(Integer::compareTo);
        right.sort(Integer::compareTo);

        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i < left.size(); i++) {
            sum.add(Math.abs(right.get(i) - left.get(i)));
        }

        return String.valueOf(sum.stream().mapToInt(Integer::intValue).sum());
    }
}
