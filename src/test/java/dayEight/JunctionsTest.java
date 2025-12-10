package dayEight;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventofcode.dayEight.Junctions;
import adventofcode.dayEight.Junctions.Coordinates;

public class JunctionsTest {
    Junctions junctions;

    @BeforeEach
    void setUp() {
        junctions = new Junctions();
    }

    @Test
    public void canFindDistanceBetweenTwoForSimpleCase() {
        Coordinates baseCoordinates = junctions.new Coordinates(0, 0, 0);
        Coordinates valueCoordinates = junctions.new Coordinates(0, 0, 0);
        double expectedResult = 0f;
        assertEquals(expectedResult, baseCoordinates.distanceTo(valueCoordinates));
    }

    @Test
    public void canFindDistanceBetweenTwo() {
        Coordinates baseCoordinates = junctions.new Coordinates(0, 0, 0);
        Coordinates valueCoordinates = junctions.new Coordinates(0, 3, 4);
        double expectedResult = 5;
        assertEquals(expectedResult, baseCoordinates.distanceTo(valueCoordinates));
    }
}
