package net.shirojr.aoc2023.attempt.day02;

import net.shirojr.common.util.DayComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day02Test {
    DayComponent day02 = new Day02("example02.txt");
    @Test
    void getDay() {
        Assertions.assertNotEquals(null, day02.getDay());
    }

    @Test
    void getProblem() {
        Assertions.assertNotEquals(null, day02.getProblem());
    }

    @Test
    void getSolution() {
        Assertions.assertEquals("8", day02.getSolution());
    }
}