package net.shirojr.aoc2023.attempt.day01;

import net.shirojr.common.util.DayComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day01Part2Test {
    DayComponent day01Part2 = new Day01Part2("2023/example01_part2.txt", new Day01("2023/example01_part2.txt"));
    @Test
    void getDay() {
        Assertions.assertEquals("01_part2", day01Part2.getDay());
    }

    @Test
    void getProblem() {
        Assertions.assertNotEquals(null, day01Part2.getProblem());
    }

    @Test
    void getSolution() {
        Assertions.assertEquals("281", day01Part2.getSolution());
    }
}