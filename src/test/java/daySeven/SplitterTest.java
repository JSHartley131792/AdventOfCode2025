package daySeven;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventofcode.daySeven.Splitter;

public class SplitterTest {
    Splitter splitter;

    @BeforeEach
    void setUp() {
        splitter = new Splitter();
    }

    @Test
    public void canRecogniseSplitStart() {
        String input = "..S..";
        int expectedResponse = 2;
        assertEquals(expectedResponse, splitter.findStartingIndex(input));
    }
}
