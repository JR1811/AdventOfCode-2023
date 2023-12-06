package net.shirojr.aoc2023.attempt.day03;

import net.shirojr.aoc2023.util.DayComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day03Test {
    DayComponent exampleDay03 = new Day03("example03.txt");
    @Test
    void getDay() {
        Assertions.assertNotEquals(null, exampleDay03.getDay());
    }

    @Test
    void getProblem() {
        Assertions.assertNotEquals(null, exampleDay03.getProblem());
    }

    @Test
    void getSolution() {
        Assertions.assertEquals("4361", exampleDay03.getSolution());

        // used for bug finding
        DayComponent day03 = new Day03("day03.txt");
        Assertions.assertEquals(535235, Integer.parseInt(day03.getSolution()));
    }
}