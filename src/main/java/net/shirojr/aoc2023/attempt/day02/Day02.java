package net.shirojr.aoc2023.attempt.day02;

import net.shirojr.aoc2023.util.DayComponent;
import net.shirojr.aoc2023.util.FileHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02 implements DayComponent {
    final FileHelper.Task task;

    public Day02(String fileName) {
        this.task = FileHelper.getPlainTextData(fileName);
    }

    @Override
    public String getDay() {
        return task.dayAndPart();
    }

    @Override
    public List<String> getProblem() {
        return task.problemLines();
    }

    @Override
    public String getSolution() {
        List<String> unprocessedLines = task.dataLines();
        List<Game> playedGames = getPlayedGames(unprocessedLines);
        List<Game> possibleGames = getPossibleGames(playedGames);

        int sum = 0;
        for (var entry : possibleGames) {
            sum += entry.index;
        }
        return String.valueOf(sum);
    }

    public List<String> getDataSetFromFile() {
        return this.task.dataLines();
    }

    public static List<Game> getPlayedGames(List<String> lines) {
        List<Game> playedGames = new ArrayList<>();
        for (int i = 1; i <= lines.size(); i++) {
            playedGames.add(getGameSet(i, lines.get(i - 1)));
        }
        return playedGames;
    }

    public static List<Game> getPossibleGames(List<Game> playedGames) {
        List<Game> possibleGames = new ArrayList<>();
        for (var gameSet : playedGames) {
            boolean isPossible = true;
            for (var game : gameSet.cubeSets) {
                for (var cubes : game) {
                    List<Game.Cubes> maxCountList = getCubesMaxCountList(12, 13, 14);
                    for (var maxCountCubes : maxCountList) {
                        if (maxCountCubes.count < cubes.count) {
                            isPossible = false;
                            break;
                        }
                    }
                }
            }
            if (isPossible) possibleGames.add(gameSet);
        }
        return possibleGames;
    }

    public static List<Game.Cubes> getCubesMaxCountList(int red, int green, int blue) {
        return List.of(new Game.Cubes(red, Game.Cubes.CubeColor.RED),
                new Game.Cubes(green, Game.Cubes.CubeColor.GREEN),
                new Game.Cubes(blue, Game.Cubes.CubeColor.BLUE));
    }

    public static Game getGameSet(int index, String line) {
        line = line.toLowerCase().replaceAll(" ", "");

        line = line.split(":")[1];

        List<String> gameSetsString = Arrays.stream(line.split(";")).toList();
        List<List<Game.Cubes>> gameSet = new ArrayList<>();
        for (String set : gameSetsString) {
            List<String> cubesString = Arrays.stream(set.split(",")).toList();
            List<Game.Cubes> cubeSet = new ArrayList<>();
            for (String entry : cubesString) {
                Game.Cubes cubes = new Game.Cubes(Integer.parseInt(entry.replaceAll("\\D", "")), Game.Cubes.CubeColor.getColor(entry.replaceAll("\\d", "")));
                cubeSet.add(cubes);
            }
            gameSet.add(cubeSet);
        }
        return new Game(index, gameSet);
    }

    public record Game(int index, List<List<Cubes>> cubeSets) {
        public int getMaxCountOfColor(Cubes.CubeColor color) {
            int count = -1;
            for (var set : cubeSets) {
                for (var cubes : set) {
                    if (cubes.color.equals(color)) {
                        count = cubes.count;
                    }
                }
            }
            return count;
        }

        public record Cubes(int count, CubeColor color) {
            public enum CubeColor {
                RED("red"), GREEN("green"), BLUE("blue");
                private final String id;

                CubeColor(String id) {
                    this.id = id;
                }

                public static CubeColor getColor(String color) {
                    for (var entry : CubeColor.values()) {
                        if (entry.id.equals(color)) return entry;
                    }
                    return null;
                }
            }
        }
    }
}
