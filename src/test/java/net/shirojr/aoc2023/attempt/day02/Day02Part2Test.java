package net.shirojr.aoc2023.attempt.day02;

import net.shirojr.common.util.DayComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day02Part2Test {
    DayComponent day02Part2 = new Day02Part2("example02_part2.txt", new Day02("example02_part2.txt"));
    @Test
    void getDay() {
        Assertions.assertNotEquals(null, day02Part2.getDay());
    }

    @Test
    void getProblem() {
        Assertions.assertNotEquals(null, day02Part2.getProblem());
    }

    @Test
    void getSolution() {
        Assertions.assertEquals("2286", day02Part2.getSolution());
    }
}