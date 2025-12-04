package dayFour;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String input = ".";
        int expectedX = 1;
        int expectedY = 1;
        boolean expectedValue = false;
        Position expectedGridPosition = forklifts.new Position(expectedX, expectedY, expectedValue);
        forklifts.applyGrid(input);
        assertEquals(forklifts.grid.get(0).getX(), expectedGridPosition.getX());
        assertEquals(forklifts.grid.get(0).getY(), expectedGridPosition.getY());
        assertEquals(forklifts.grid.get(0).getValue(), expectedGridPosition.getValue());
    }
    
    @Test
    public void canApplyPositionWithinGridForPaper() {
        String input = "@";
        int expectedX = 1;
        int expectedY = 1;
        boolean expectedValue = true;
        Position expectedGridPosition = forklifts.new Position(expectedX, expectedY, expectedValue);
        forklifts.applyGrid(input);
        assertEquals(forklifts.grid.get(0).getX(), expectedGridPosition.getX());
        assertEquals(forklifts.grid.get(0).getY(), expectedGridPosition.getY());
        assertEquals(forklifts.grid.get(0).getValue(), expectedGridPosition.getValue());
    }
}
