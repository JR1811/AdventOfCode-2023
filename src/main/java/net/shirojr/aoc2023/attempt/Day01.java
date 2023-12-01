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
        return null;
    }
}
