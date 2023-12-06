package net.shirojr.aoc2023;

import net.shirojr.aoc2023.attempt.day01.Day01;
import net.shirojr.aoc2023.attempt.day01.Day01Part2;
import net.shirojr.aoc2023.attempt.day02.Day02;
import net.shirojr.aoc2023.attempt.day02.Day02Part2;
import net.shirojr.aoc2023.attempt.day03.Day03;
import net.shirojr.aoc2023.util.DayComponent;

import java.util.ArrayList;
import java.util.List;

public class DaysManager {
    public List<DayComponent> days = new ArrayList<>();

    public DaysManager() {
        DayComponent day01 = new Day01("day01.txt");
        DayComponent day01Part2 = new Day01Part2("day01_part2.txt", day01);
        DayComponent day02 = new Day02("day02.txt");
        DayComponent day02Part2 = new Day02Part2("day02_part2.txt", day02);
        DayComponent day03 = new Day03("day03.txt");

        days.add(day01);
        days.add(day01Part2);
        days.add(day02);
        days.add(day02Part2);
        days.add(day03);
    }
}
