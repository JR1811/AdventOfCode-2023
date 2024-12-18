package net.shirojr.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHelper {
    public static Task getPlainTextData(String fileName) {
        List<String> lines = new ArrayList<>();
        File file = new File("src/main/resources/input/" + fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        }
        List<String> problem = new ArrayList<>();
        List<String> data = new ArrayList<>();
        String divider = "---divider---";
        boolean isData = false;
        for (String line : lines) {
            if (line.isBlank()) continue;
            if (line.contains(divider)) {
                isData = true;
                continue;
            }
            if (isData) data.add(line);
            else problem.add(line);
        }
        String dayAndPart = "";
        if (fileName.contains("day")) {
            dayAndPart = fileName.split("day")[1].split(".txt")[0];
        } else if (fileName.contains("example")) {
            dayAndPart = fileName.split("example")[1].split(".txt")[0];
        }
        return new Task(dayAndPart, problem, data);
    }

    public record Task(String dayAndPart, List<String> problemLines, List<String> dataLines) {
    }
}
