package net.shirojr.common.util;

public class TextHelper {
    private TextHelper() {
    }

    public static void printGreeting() {
        System.out.print("This is ShiroJR's attempt at AoC-2023!");
    }

    public static void printHeader(String title) {
        System.out.printf("%n--------------------- [%s] ---------------------%n", title);
    }
    public static void printSpace(int lines) {
        for (int i = 0; i < lines; i++) System.out.println();
    }
    public static void printSpace() {
        printSpace(1);
    }
}
