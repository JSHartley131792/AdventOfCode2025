package adventofcode.daySeven;

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

    
}
