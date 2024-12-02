package net.shirojr.aoc2023.attempt.day01;

import net.shirojr.common.util.DayComponent;
import net.shirojr.common.util.FileHelper;

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
        int sum = 0;
        for (String line : task.dataLines()) {
            sum += Integer.parseInt(getFirstAndLastDigitFromLine(line));
        }
        return String.valueOf(sum);
    }

    public List<String> getDataSetFromFile() {
        return this.task.dataLines();
    }

    private static String getFirstAndLastDigitFromLine(String input) {
        String number = input.toLowerCase().replaceAll("[a-z]", "");
        String digits = String.valueOf(number.charAt(0));
        digits += number.charAt(number.length() - 1);
        return digits;
    }
}
