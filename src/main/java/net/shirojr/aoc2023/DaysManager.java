package net.shirojr.aoc2023;

import net.shirojr.aoc2023.attempt.Day01;
import net.shirojr.aoc2023.util.DayComponent;

import java.util.ArrayList;
import java.util.List;

public class DaysManager {
    public List<DayComponent> days = new ArrayList<>();

    public DaysManager() {
        days.add(new Day01());
    }
}
