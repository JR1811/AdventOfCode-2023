package net.shirojr.aoc2023.attempt.day03;

import net.shirojr.aoc2023.util.DayComponent;
import net.shirojr.aoc2023.util.FileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Day03 implements DayComponent {
    final FileHelper.Task task;

    public Day03(String fileName) {
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
        List<PotentialPartNumber> confirmedParts = new ArrayList<>();
        for (int i = 0; i < task.dataLines().size(); i++) {
            String line = task.dataLines().get(i);
            StringBuilder potentialPartStringBuilder = new StringBuilder();
            List<PotentialPartNumber> partNumbers = new ArrayList<>();
            for (int j = 0; j < line.toCharArray().length; j++) {
                char currentChar = line.toCharArray()[j];
                Symbol.SymbolType symbolType = Symbol.SymbolType.getSymbolType(currentChar);
                switch (symbolType) {
                    case NUMBER -> {
                        potentialPartStringBuilder.append(currentChar);
                        if (j == line.toCharArray().length - 1) {   // is last symbol in line
                            String finishedPartName = potentialPartStringBuilder.toString();
                            PotentialPartNumber partNumber =
                                    new PotentialPartNumber(j - finishedPartName.length() + 1, i,
                                            potentialPartStringBuilder.toString(), new ArrayList<>());
                            partNumbers.add(partNumber);
                        }
                    }
                    case EMPTY, SYMBOL -> {
                        if (j < 1) continue;
                        String finishedPartName = potentialPartStringBuilder.toString();
                        if (finishedPartName.isBlank()) continue;
                        partNumbers.add(new PotentialPartNumber(j - finishedPartName.length(), i, finishedPartName, new ArrayList<>()));
                        potentialPartStringBuilder.setLength(0);
                    }
                }
            }

            for (PotentialPartNumber partNumber : partNumbers) {
                List<Symbol> horizontalConfirmationSymbols = Symbol.getHorizontalConfirmationChars(line, partNumber);
                List<Symbol> verticalConfirmationSymbols = Symbol.getVerticalConfirmationChars(task.dataLines(), i, partNumber);
                List<Symbol> diagonalConfirmationSymbols = Symbol.getDiagonalConfirmationChars(task.dataLines(), i, partNumber);
                partNumber.confirmingSymbols.addAll(horizontalConfirmationSymbols);
                partNumber.confirmingSymbols.addAll(verticalConfirmationSymbols);
                partNumber.confirmingSymbols.addAll(diagonalConfirmationSymbols);

                if (!partNumber.confirmingSymbols.isEmpty()) {
                    PotentialPartNumber.addConfirmedPartToList(confirmedParts, partNumber);
                }
            }
        }

        int sum = 0;
        for (var entry : confirmedParts) {
            sum = sum + Integer.parseInt(entry.partName);
        }

        return String.valueOf(sum);
    }

    @Override
    public List<String> getDataSetFromFile() {
        return this.task.dataLines();
    }

    public record Symbol(int index, char symbol, SymbolType type) {
        public static List<Symbol> getHorizontalConfirmationChars(String line, PotentialPartNumber partNumber) {
            List<Symbol> symbols = new ArrayList<>();
            int index;
            if (partNumber.indexRange[0] > 0) {
                index = partNumber.indexRange[0] - 1;
                if (SymbolType.getSymbolType(line.charAt(index)).equals(SymbolType.SYMBOL)) {
                    symbols.add(new Symbol(index, line.charAt(index), SymbolType.SYMBOL));
                }
            }
            if (partNumber.indexRange[0] + partNumber.getPartNumberLength() < line.length() - 1) {
                index = partNumber.indexRange[0] + partNumber.getPartNumberLength();
                if (SymbolType.getSymbolType(line.charAt(index)).equals(SymbolType.SYMBOL)) {
                    symbols.add(new Symbol(index, line.charAt(index), SymbolType.SYMBOL));
                }
            }
            return symbols;
        }

        public static List<Symbol> getVerticalConfirmationChars(List<String> lines, int currentLine, PotentialPartNumber partNumber) {
            List<Symbol> symbols = new ArrayList<>();
            // check top side boundary
            if (currentLine > 0) {
                String lineAbove = lines.get(currentLine - 1);
                String potentialSymbols = lineAbove.substring(partNumber.indexRange[0], partNumber.indexRange[1]);
                for (int i = 0; i < potentialSymbols.toCharArray().length; i++) {
                    char entry = potentialSymbols.charAt(i);
                    SymbolType type = SymbolType.getSymbolType(entry);
                    if (type.equals(SymbolType.SYMBOL)) {
                        symbols.add(new Symbol(currentLine - 1, lineAbove.charAt(i), type));
                    }
                }
            }
            // check bottom side boundary
            if (currentLine < lines.size() - 1) {
                String lineBelow = lines.get(currentLine + 1);
                String potentialSymbols = lineBelow.substring(partNumber.indexRange[0], partNumber.indexRange[1]);
                for (int i = 0; i < potentialSymbols.toCharArray().length; i++) {
                    char entry = potentialSymbols.charAt(i);
                    SymbolType type = SymbolType.getSymbolType(entry);
                    if (type.equals(SymbolType.SYMBOL)) {
                        symbols.add(new Symbol(currentLine + 1, lineBelow.charAt(i), type));
                    }
                }
            }

            return symbols;
        }

        public static List<Symbol> getDiagonalConfirmationChars(List<String> lines, int currentLine, PotentialPartNumber partNumber) {
            List<Symbol> symbols = new ArrayList<>();
            String line = lines.get(currentLine);
            String lineAbove = currentLine > 0 ? lines.get(currentLine - 1) : null;
            String lineBelow = currentLine < lines.size() - 1 ? lines.get(currentLine + 1) : null;

            // check left side boundary
            if (partNumber.indexRange[0] > 0) {
                int index = partNumber.indexRange[0] - 1;
                if (lineAbove != null && SymbolType.getSymbolType(lineAbove.charAt(index)).equals(SymbolType.SYMBOL)) {
                    symbols.add(new Symbol(index, lineAbove.charAt(index), SymbolType.SYMBOL));
                }
                if (lineBelow != null && SymbolType.getSymbolType(lineBelow.charAt(index)).equals(SymbolType.SYMBOL)) {
                    symbols.add(new Symbol(index, lineBelow.charAt(index), SymbolType.SYMBOL));
                }
            }
            // check right side boundary
            if (partNumber.indexRange[1]  < line.length() - 1) {
                int index = partNumber.indexRange[0] + partNumber.getPartNumberLength();
                if (lineAbove != null && SymbolType.getSymbolType(lineAbove.charAt(index)).equals(SymbolType.SYMBOL)) {
                    symbols.add(new Symbol(index, lineAbove.charAt(index), SymbolType.SYMBOL));
                }
                if (lineBelow != null && SymbolType.getSymbolType(lineBelow.charAt(index)).equals(SymbolType.SYMBOL)) {
                    symbols.add(new Symbol(index, lineBelow.charAt(index), SymbolType.SYMBOL));
                }
            }
            return symbols;
        }

        public enum SymbolType {
            NUMBER("\\d"),
            SYMBOL("[^.\\d]"),
            EMPTY(".");

            private final String regexMatch;

            SymbolType(String regexTest) {
                this.regexMatch = regexTest;
            }

            public Pattern getPattern() {
                return Pattern.compile(this.regexMatch);
            }

            public static SymbolType getSymbolType(char c) {
                for (var entry : SymbolType.values()) {
                    if (entry.getPattern().matcher(String.valueOf(c)).find()) return entry;
                }
                return SymbolType.EMPTY;
            }
        }
    }

    public static class PotentialPartNumber {
        private final int[] indexRange = new int[2];
        private final int lineNumber;
        private final String partName;
        private final List<Symbol> confirmingSymbols;

        public PotentialPartNumber(int index, int lineNumber, String partName, List<Symbol> confirmingSymbols) {
            this.indexRange[0] = index;
            this.indexRange[1] = index + partName.length();
            this.lineNumber = lineNumber;
            this.partName = partName;
            this.confirmingSymbols = confirmingSymbols;
        }

        public String getPartName() {
            return partName;
        }

        public int getLineNumber() {
            return lineNumber;
        }

        public int getPartNumberLength() {
            return Math.max(this.indexRange[1] - this.indexRange[0], 0);
        }

        public boolean isConfirmed() {
            return this.confirmingSymbols != null;
        }

        public List<Symbol> getConfirmingSymbols() {
            return this.confirmingSymbols;
        }

        public static void addConfirmedPartToList(List<PotentialPartNumber> partNumbers, PotentialPartNumber partNumber) {
            if (partNumbers.contains(partNumber)) return;
            partNumbers.add(partNumber);
        }
    }
}
