package net.shirojr.aoc2023.util;

import java.util.List;

public interface DayComponent {
    String getDay();

    List<String> getProblem();

    default List<String> getDataSetFromFile() {
        return null;
    }

    String getSolution();
}
