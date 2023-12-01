package net.shirojr.aoc2023.attempt;

import net.shirojr.aoc2023.util.DayComponent;
import net.shirojr.aoc2023.util.FileHelper;

import java.util.List;

public class Day01 implements DayComponent {
    private final FileHelper.Task task = FileHelper.getPlainTextData("day01.txt");

    @Override
    public int getDay() {
        return task.day();
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

    private static String getFirstAndLastDigitFromLine(String input) {
        String number = input.toLowerCase().replaceAll("[a-z]", "");
        String digits = String.valueOf(number.charAt(0));
        digits += number.charAt(number.length() - 1);
        return digits;
    }
}
