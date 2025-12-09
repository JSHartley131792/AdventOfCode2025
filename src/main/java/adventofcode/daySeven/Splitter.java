package adventofcode.daySeven;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Splitter {
    public int splitCount = 0;
    public long possibleRoutes = 0L;

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

    // each time a particle reaches a splitter, it's actually time itself which
    // splits. In one timeline, the particle went left, and in the other timeline,
    // the particle went right.

    // To fix the manifold, what you really need to know is the number of timelines
    // active after a single particle completes all of its possible journeys through
    // the manifold.

    public long[] findStartingIndex(String input, long[] positionTotals) {
        Set<Integer> startingIndex = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'S') {
                startingIndex.add(i);
                positionTotals[i]++;
            }
        }
        currentIndices = startingIndex;
        return positionTotals;
    }

    public void addPath(String nextLine, long[] possibleRoutes) {
        Set<Integer> newIndex = new HashSet<>();
        for (Integer index : currentIndices) {
            if (nextLine.charAt(index) == '^') {
                newIndex.add(index - 1);
                newIndex.add(index + 1);
                splitCount++;
                possibleRoutes[index - 1] += possibleRoutes[index];
                possibleRoutes[index + 1] += possibleRoutes[index] ;
                possibleRoutes[index] = 0;
            } else {
                newIndex.add(index);
            }
        }
        if (newIndex.size() == 0) {
            return;
        }
        currentIndices = newIndex;
    }

    public void solveForPartTwo(List<String> puzzleInput) {
        int lengthOfLine = puzzleInput.get(0).length();
        long[] positionTotals = new long[lengthOfLine];
        findStartingIndex(puzzleInput.get(0), positionTotals);
        for (int i = 1; i < puzzleInput.size(); i++) {
            addPath(puzzleInput.get(i), positionTotals);
        }
        for (long i : positionTotals) {
            possibleRoutes+= i;
        }
    }
}
