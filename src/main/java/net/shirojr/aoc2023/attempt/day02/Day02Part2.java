package net.shirojr.aoc2023.attempt.day02;

import net.shirojr.aoc2023.util.DayComponent;
import net.shirojr.aoc2023.util.FileHelper;

import java.util.List;

public class Day02Part2 implements DayComponent {

    private final FileHelper.Task task;

    private final DayComponent day02;

    public Day02Part2(String fileName, DayComponent dayComponent) {
        this.day02 = dayComponent;
        this.task = FileHelper.getPlainTextData(fileName);
    }

    @Override
    public String getDay() {
        return this.task.dayAndPart();
    }

    @Override
    public List<String> getProblem() {
        return this.task.problemLines();
    }

    @Override
    public String getSolution() {


        return null;
    }
}
