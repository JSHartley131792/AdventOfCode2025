package dayFour;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
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
        int expectedX = 1;
        int expectedY = 1;
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
        int expectedX = 1;
        int expectedY = 1;
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
        Position expectedFirstGridPosition = forklifts.new Position(1, 1, false);
        Position expectedSecondGridPosition = forklifts.new Position(2, 1, true);
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
        Position expectedOneOnePosition = forklifts.new Position(1, 1, false);
        Position expectedTwoOnePosition = forklifts.new Position(2, 1, true);
        Position expectedOneTwoPosition = forklifts.new Position(1, 2, true);
        Position expectedTwoTwoPosition = forklifts.new Position(2, 2, false);
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
        Position expectedPosition = forklifts.new Position(2, 2, false);
        forklifts.applyGrid(strings);
        Position resultPosition = forklifts.getPositionByAxis(2, 2);
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
        forklifts.findNearbyPaper(2, 2);
        int expectedResult = 0;
        assertEquals(forklifts.getPositionByAxis(2, 2).getNearbyPaper(), expectedResult);
    }
    
    @Test
    public void canDiscoverNeighbouringPaperWhenSurrounded() {
        List<String> strings = new ArrayList<>();
        strings.add("@@@");
        strings.add("@@@");
        strings.add("@@@");
        forklifts.applyGrid(strings);
        forklifts.findNearbyPaper(2, 2);
        int expectedResult = 8;
        assertEquals(expectedResult, forklifts.getPositionByAxis(2, 2).getNearbyPaper());
    }
    
    @Test
    public void canDiscoverLessThanFour() {
        List<String> strings = new ArrayList<>();
        strings.add("@@@");
        strings.add("@@@");
        strings.add("@@@");
        forklifts.applyGrid(strings);
        forklifts.findNearbyPaper(2, 2);
        boolean expectedResult = false;
        assertEquals(expectedResult, forklifts.getPositionByAxis(2, 2).getCanAccess());
    }
    
    @Test
    public void canDiscoverLessThanFourWhenPossible() {
        List<String> strings = new ArrayList<>();
        strings.add("@.");
        strings.add(".@");
        forklifts.applyGrid(strings);
        forklifts.findNearbyPaper(2, 2);
        boolean expectedResult = true;
        assertEquals(expectedResult, forklifts.getPositionByAxis(2, 2).getCanAccess());
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
}
