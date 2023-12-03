package net.shirojr.aoc2023.attempt.day01;

import net.shirojr.aoc2023.attempt.day01.Day01;
import net.shirojr.aoc2023.attempt.day01.Day01Part2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day01Part2Test {
    Day01Part2 day01Part2 = new Day01Part2("example01_part2.txt", new Day01("example01_part2.txt"));
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