package net.shirojr.aoc2023;

import net.shirojr.aoc2023.attempt.Day01;
import net.shirojr.aoc2023.attempt.Day01Part2;
import net.shirojr.aoc2023.util.DayComponent;

import java.util.ArrayList;
import java.util.List;

public class DaysManager {
    public List<DayComponent> days = new ArrayList<>();

    public DaysManager() {
        DayComponent day01 = new Day01();
        DayComponent day01Part2 = new Day01Part2(day01);

        days.add(day01);
        days.add(day01Part2);
    }
}
