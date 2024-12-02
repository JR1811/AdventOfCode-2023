package net.shirojr.common;

import net.shirojr.common.util.DayComponent;

import java.util.ArrayList;
import java.util.List;

public class DaysManager {
    public List<DayComponent> days = new ArrayList<>();

    public DaysManager() {
        //2023
        DayComponent day01y23 = new net.shirojr.aoc2023.attempt.day01.Day01("2023/day01.txt");
        DayComponent day01Part2y23 = new net.shirojr.aoc2023.attempt.day01.Day01Part2("2023/day01_part2.txt", day01y23);
        DayComponent day02y23 = new net.shirojr.aoc2023.attempt.day02.Day02("2023/day02.txt");
        DayComponent day02Part2y23 = new net.shirojr.aoc2023.attempt.day02.Day02Part2("2023/day02_part2.txt", day02y23);
        DayComponent day03y23 = new net.shirojr.aoc2023.attempt.day03.Day03("2023/day03.txt");

        days.add(day01y23);
        days.add(day01Part2y23);
        days.add(day02y23);
        days.add(day02Part2y23);
        days.add(day03y23);

        //2024
        DayComponent day01y24 = new net.shirojr.aoc2024.attempt.day01.Day01("2024/day01.txt");
        DayComponent day01Part2y24 = new net.shirojr.aoc2024.attempt.day01.Day01Part2("2024/day01_part2.txt");

        days.add(day01y24);
        days.add(day01Part2y24);
    }
}
