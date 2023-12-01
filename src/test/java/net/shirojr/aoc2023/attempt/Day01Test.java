package net.shirojr.aoc2023.attempt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {
    Day01 day01 = new Day01();

    @Test
    void getDay() {
        Assertions.assertEquals(1, day01.getDay());
    }

    @Test
    void getProblem() {
        Assertions.assertNotEquals(null, day01.getProblem());
    }

    @Test
    void getSolution() {
        Assertions.assertNotEquals(null, day01.getSolution());
    }
}