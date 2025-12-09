package adventofcode.daySeven;

import java.util.ArrayList;
import java.util.List;

public class Splitter {
    int splitCount;

    public Splitter() {
    }

    public List<Integer> findStartingIndex(String input) {
        List<Integer> startingIndex = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'S') {
                startingIndex.add(i);
            }
        }
        return startingIndex;
    }

    public List<Integer> findSplit(String nextLine, List<Integer> currentIndex) {
        List<Integer> newIndex = new ArrayList<>();
        for (Integer index : currentIndex) {
            if (nextLine.charAt(index) == '^') {
                newIndex.add(index - 1);
                newIndex.add(index + 1);
            }
        }
        if (newIndex.size() == 0) {
            return currentIndex;
        }
        return newIndex;
    }
}
