package net.shirojr.common;

import net.shirojr.common.util.DayComponent;
import net.shirojr.common.util.TextHelper;

public class Main {
    public static DaysManager manager = new DaysManager();

    public static void main(String[] args) {
        TextHelper.printHeader("Hello AoC-2023!");
        TextHelper.printGreeting();
        TextHelper.printSpace(1);

        for (DayComponent day : manager.days) {
            TextHelper.printHeader("Day " + day.getDay());
            for (String problemLine : day.getProblem()) {
                System.out.println(problemLine);
            }
            TextHelper.printSpace();
            System.out.println(day.getSolution());
        }
    }
}