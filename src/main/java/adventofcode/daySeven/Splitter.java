package adventofcode.daySeven;

import java.util.List;

public class Splitter {
    int splitCount;

    public Splitter() {}

    public Integer findStartingIndex(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'S') {
                return i;
            }
        }
        return 0;
    }

    public List<Integer> findSplit(String nextLine, List<Integer> currentIndex) {
        return currentIndex;
    }

    
}
