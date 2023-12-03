package net.shirojr.aoc2023.attempt.day01;

import net.shirojr.aoc2023.attempt.day01.Day01;
import net.shirojr.aoc2023.util.DayComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day01Test {
    DayComponent day01 = new Day01("example01.txt");

    @Test
    void getDay() {
        Assertions.assertEquals("01", day01.getDay());
    }

    @Test
    void getProblem() {
        Assertions.assertNotEquals(null, day01.getProblem());
    }

    @Test
    void getSolution() {
        Assertions.assertEquals("142", day01.getSolution());
    }
}