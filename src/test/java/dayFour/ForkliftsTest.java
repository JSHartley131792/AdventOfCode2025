package dayFour;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventofcode.dayFour.Forklifts;
import adventofcode.dayFour.Forklifts.Position;

public class ForkliftsTest {
    Forklifts forklifts;

    @BeforeEach
    void setUp() {
        forklifts = new Forklifts();
    }

    @Test
    public void canApplyPositionWithinGrid() {
        List<String> strings = new ArrayList<>();
        String input = ".";
        strings.add(input);
        int expectedX = 0;
        int expectedY = 0;
        boolean expectedValue = false;
        Position expectedGridPosition = forklifts.new Position(expectedX, expectedY, expectedValue);
        forklifts.applyGrid(strings);
        assertEquals(forklifts.grid.get(0).getX(), expectedGridPosition.getX());
        assertEquals(forklifts.grid.get(0).getY(), expectedGridPosition.getY());
        assertEquals(forklifts.grid.get(0).getValue(), expectedGridPosition.getValue());
    }

    @Test
    public void canApplyPositionWithinGridForPaper() {
        List<String> strings = new ArrayList<>();
        String input = "@";
        strings.add(input);
        int expectedX = 0;
        int expectedY = 0;
        boolean expectedValue = true;
        Position expectedGridPosition = forklifts.new Position(expectedX, expectedY, expectedValue);
        forklifts.applyGrid(strings);
        assertEquals(forklifts.grid.get(0).getX(), expectedGridPosition.getX());
        assertEquals(forklifts.grid.get(0).getY(), expectedGridPosition.getY());
        assertEquals(forklifts.grid.get(0).getValue(), expectedGridPosition.getValue());
    }

    @Test
    public void canApplyPositionWithinGridForLongerString() {
        List<String> strings = new ArrayList<>();
        String input = ".@";
        strings.add(input);
        Position expectedFirstGridPosition = forklifts.new Position(0, 0, false);
        Position expectedSecondGridPosition = forklifts.new Position(1, 0, true);
        forklifts.applyGrid(strings);
        assertEquals(forklifts.grid.get(0).getX(), expectedFirstGridPosition.getX());
        assertEquals(forklifts.grid.get(0).getY(), expectedFirstGridPosition.getY());
        assertEquals(forklifts.grid.get(0).getValue(), expectedFirstGridPosition.getValue());
        assertEquals(forklifts.grid.get(1).getX(), expectedSecondGridPosition.getX());
        assertEquals(forklifts.grid.get(1).getY(), expectedSecondGridPosition.getY());
        assertEquals(forklifts.grid.get(1).getValue(), expectedSecondGridPosition.getValue());
    }

    @Test
    public void canApplyPositionWithinGridForMultipleStrings() {
        List<String> strings = new ArrayList<>();
        strings.add(".@");
        strings.add("@.");
        Position expectedOneOnePosition = forklifts.new Position(0, 0, false);
        Position expectedTwoOnePosition = forklifts.new Position(1, 0, true);
        Position expectedOneTwoPosition = forklifts.new Position(0, 1, true);
        Position expectedTwoTwoPosition = forklifts.new Position(1, 1, false);
        forklifts.applyGrid(strings);
        assertEquals(forklifts.grid.get(0).getX(), expectedOneOnePosition.getX());
        assertEquals(forklifts.grid.get(0).getY(), expectedOneOnePosition.getY());
        assertEquals(forklifts.grid.get(0).getValue(), expectedOneOnePosition.getValue());
        assertEquals(forklifts.grid.get(1).getX(), expectedTwoOnePosition.getX());
        assertEquals(forklifts.grid.get(1).getY(), expectedTwoOnePosition.getY());
        assertEquals(forklifts.grid.get(1).getValue(), expectedTwoOnePosition.getValue());
        assertEquals(forklifts.grid.get(2).getX(), expectedOneTwoPosition.getX());
        assertEquals(forklifts.grid.get(2).getY(), expectedOneTwoPosition.getY());
        assertEquals(forklifts.grid.get(2).getValue(), expectedOneTwoPosition.getValue());
        assertEquals(forklifts.grid.get(3).getX(), expectedTwoTwoPosition.getX());
        assertEquals(forklifts.grid.get(3).getY(), expectedTwoTwoPosition.getY());
        assertEquals(forklifts.grid.get(3).getValue(), expectedTwoTwoPosition.getValue());
    }

    @Test
    void canGetFromSpecificPosition() {
        List<String> strings = new ArrayList<>();
        strings.add(".@");
        strings.add("@.");
        Position expectedPosition = forklifts.new Position(1, 1, false);
        forklifts.applyGrid(strings);
        Position resultPosition = forklifts.getPositionByAxis(1, 1);
        assertEquals(resultPosition.getX(), expectedPosition.getX());
        assertEquals(resultPosition.getY(), expectedPosition.getY());
        assertEquals(resultPosition.getValue(), expectedPosition.getValue());
    }

    @Test
    public void canDiscoverNeighbouringPaper() {
        List<String> strings = new ArrayList<>();
        strings.add("...");
        strings.add("...");
        strings.add("...");
        forklifts.applyGrid(strings);
        forklifts.findNearbyPaper(1, 1);
        int expectedResult = 0;
        assertEquals(forklifts.getPositionByAxis(1, 1).getNearbyPaper(), expectedResult);
    }

    @Test
    public void canDiscoverNeighbouringPaperWhenSurrounded() {
        List<String> strings = new ArrayList<>();
        strings.add("@@@");
        strings.add("@@@");
        strings.add("@@@");
        forklifts.applyGrid(strings);
        forklifts.findNearbyPaper(1, 1);
        int expectedResult = 8;
        assertEquals(expectedResult, forklifts.getPositionByAxis(1, 1).getNearbyPaper());
    }

    @Test
    public void canDiscoverLessThanFour() {
        List<String> strings = new ArrayList<>();
        strings.add("@@@");
        strings.add("@@@");
        strings.add("@@@");
        forklifts.applyGrid(strings);
        forklifts.findNearbyPaper(1, 1);
        boolean expectedResult = false;
        assertEquals(expectedResult, forklifts.getPositionByAxis(1, 1).getCanAccess());
    }

    @Test
    public void canDiscoverLessThanFourWhenPossible() {
        List<String> strings = new ArrayList<>();
        strings.add("@.");
        strings.add(".@");
        forklifts.applyGrid(strings);
        forklifts.findNearbyPaper(1, 1);
        boolean expectedResult = true;
        assertEquals(expectedResult, forklifts.getPositionByAxis(1, 1).getCanAccess());
    }

    @Test
    public void canDiscoverLessThanFourWhenPossibleLargerGrid() {
        List<String> strings = new ArrayList<>();
        strings.add("@@@");
        strings.add("@@@");
        strings.add("@@@");
        forklifts.applyGrid(strings);
        forklifts.findNearbyPaper(2, 0);
        boolean expectedResult = true;
        assertEquals(expectedResult, forklifts.getPositionByAxis(2, 0).getCanAccess());
    }

    @Test
    public void canGetCountForGrid() {
        List<String> strings = new ArrayList<>();
        strings.add("@.");
        strings.add(".@");
        forklifts.applyGrid(strings);
        long expectedResult = 2;
        assertEquals(expectedResult, forklifts.getTotalAccess());
    }

    @Test
    public void canGetCountForGridWhenNone() {
        List<String> strings = new ArrayList<>();
        strings.add("@@@");
        strings.add("@@@");
        strings.add("@@@");
        forklifts.applyGrid(strings);
        long expectedResult = 4;
        assertEquals(expectedResult, forklifts.getTotalAccess());
    }

    @Test
    public void canReadFileIn() {
        forklifts.readForklifts("test", "input");
        long expectedResult = 13;
        assertEquals(expectedResult, forklifts.getTotalAccess());
    }
}
