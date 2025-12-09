package adventofcode.daySeven;

import java.util.HashSet;
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
            }
        }
        if (newIndex.size() == 0) {
            return;
        }
        currentIndices = newIndex;
    }
}
