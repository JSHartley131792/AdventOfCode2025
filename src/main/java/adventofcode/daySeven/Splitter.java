package adventofcode.daySeven;

import java.util.ArrayList;
import java.util.List;

public class Splitter {
    public int splitCount = 0;

    public List<Integer> currentIndices = new ArrayList<>();

    public Splitter() {
    }

    public void findStartingIndex(String input) {
        List<Integer> startingIndex = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'S') {
                startingIndex.add(i);
            }
        }
        currentIndices = startingIndex;
    }

    public void findSplit(String nextLine) {
        List<Integer> newIndex = new ArrayList<>();
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
