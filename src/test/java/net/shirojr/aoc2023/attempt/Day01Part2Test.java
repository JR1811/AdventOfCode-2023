package net.shirojr.aoc2023.attempt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day01Part2Test {
    Day01Part2 day01Part2 = new Day01Part2(new Day01());
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
        Assertions.assertEquals("52840", day01Part2.getSolution());
    }
}