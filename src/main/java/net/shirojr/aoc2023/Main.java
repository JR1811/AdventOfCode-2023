package net.shirojr.aoc2023;

import net.shirojr.aoc2023.util.DayComponent;
import net.shirojr.aoc2023.util.TextHelper;

public class Main {
    public static DaysManager manager = new DaysManager();

    public static void main(String[] args) {
        TextHelper.printHeader("Hello AoC-2023!");
        TextHelper.printGreeting();
        TextHelper.printSpace(1);

        for (DayComponent day : manager.days) {
            TextHelper.printHeader("Day " + day.getDay());
            System.out.println(day.getProblem());
            TextHelper.printSpace();
            System.out.println(day.getSolution());
        }
    }
}