package net.shirojr.common.util;

import java.util.List;

public interface DayComponent {
    String getDay();

    List<String> getProblem();

    default List<String> getDataSetFromFile() {
        return null;
    }

    String getSolution();
}
