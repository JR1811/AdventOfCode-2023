package net.shirojr.aoc2023.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHelper {
    public static List<String> getPlainTextData(String fileName) {
        List<String> lines = new ArrayList<>();
        File file = new File("src/main/resources/input/" + fileName);

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                lines.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
