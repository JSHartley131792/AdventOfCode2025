package adventofcode.daySeven;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Splitter {
    public int splitCount = 0;

    public Set<Integer> currentIndices = new HashSet<>();

    public Splitter() {
    }

    public void findStartingIndex(String input) {
        Set<Integer> startingIndex = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'S') {
                startingIndex.add(i);
            }
        }
        currentIndices = startingIndex;
    }

    public void findSplit(String nextLine) {
        Set<Integer> newIndex = new HashSet<>();
        for (Integer index : currentIndices) {
            if (nextLine.charAt(index) == '^') {
                newIndex.add(index - 1);
                newIndex.add(index + 1);
                splitCount++;
            } else {
                newIndex.add(index);
            }
        }
        if (newIndex.size() == 0) {
            return;
        }
        currentIndices = newIndex;
    }

    public void solveForPartOne(List<String> puzzleInput) {
        findStartingIndex(puzzleInput.get(0));
        for (int i = 1; i < puzzleInput.size(); i++) {
            findSplit(puzzleInput.get(i));
        }
    }
}
