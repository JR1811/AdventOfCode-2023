package net.shirojr.aoc2023.attempt.day02;

import net.shirojr.common.util.DayComponent;
import net.shirojr.common.util.FileHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day02Part2 implements DayComponent {

    private final FileHelper.Task task;

    private final DayComponent day02;

    public Day02Part2(String fileName, DayComponent dayComponent) {
        this.day02 = dayComponent;
        this.task = FileHelper.getPlainTextData(fileName);
    }

    @Override
    public String getDay() {
        return this.task.dayAndPart();
    }

    @Override
    public List<String> getProblem() {
        return this.task.problemLines();
    }

    @Override
    public String getSolution() {
        List<String> unprocessedLines = day02.getDataSetFromFile();
        List<Day02.Game> playedGames = Day02.getPlayedGames(unprocessedLines);

        int sum = 0;
        for (Day02.Game game : playedGames) {
            List<Integer> lowestPossibleCounts = getLowestPossibleCountOfCubesInSet(game).values().stream().toList();
            sum += lowestPossibleCounts.stream().reduce(1, (a, b) -> a * b);
        }

        return String.valueOf(sum);
    }

    public static Map<Day02.Game.Cubes.CubeColor, Integer> getLowestPossibleCountOfCubesInSet(Day02.Game games) {
        Map<Day02.Game.Cubes.CubeColor, Integer> lowestCountForColor = new HashMap<>();
        for (var cubes : games.cubeSets()) {
            for (var entry : cubes) {
                if (!lowestCountForColor.containsKey(entry.color())) {
                    lowestCountForColor.put(entry.color(), entry.count());
                }
                for (var colorEntry : lowestCountForColor.entrySet()) {
                    if (!colorEntry.getKey().equals(entry.color())) continue;
                    if (colorEntry.getValue() < entry.count()) colorEntry.setValue(entry.count());
                }
            }
        }
        return lowestCountForColor;
    }
}
