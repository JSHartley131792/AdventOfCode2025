package dayEight;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventofcode.dayEight.Junctions;
import adventofcode.dayEight.Junctions.CoordinateSystem;
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

    @Test
    public void canFindClosest() {
        // Arrange
        Coordinates baseCoordinates = junctions.new Coordinates(0, 0, 0);
        Coordinates farCoordinates = junctions.new Coordinates(0, 3, 4);
        Coordinates nearCoordinates = junctions.new Coordinates(0, 1, 1);
        CoordinateSystem baseSystem = junctions.new CoordinateSystem(baseCoordinates, false);
        CoordinateSystem farSystem = junctions.new CoordinateSystem(farCoordinates, false);
        CoordinateSystem nearSystem = junctions.new CoordinateSystem(nearCoordinates, false);
        junctions.listOfCoordinates.add(baseSystem);
        junctions.listOfCoordinates.add(farSystem);
        junctions.listOfCoordinates.add(nearSystem);
        // Act
        baseSystem.findClosest(junctions.listOfCoordinates, 0);
        // Assert
        long expectedIndexLinkToBase = 2;
        assertEquals(expectedIndexLinkToBase, baseSystem.indexOfLinked);
    }

    @Test
    public void canLinkAllInSystem() {
        // Arrange
        Coordinates baseCoordinates = junctions.new Coordinates(0, 0, 0);
        Coordinates farCoordinates = junctions.new Coordinates(8, 8, 8);
        Coordinates nearCoordinates = junctions.new Coordinates(0, 1, 1);
        Coordinates furtherCoordinates = junctions.new Coordinates(9, 9, 9);
        CoordinateSystem baseSystem = junctions.new CoordinateSystem(baseCoordinates, false);
        CoordinateSystem farSystem = junctions.new CoordinateSystem(farCoordinates, false);
        CoordinateSystem nearSystem = junctions.new CoordinateSystem(nearCoordinates, false);
        CoordinateSystem furtherSystem = junctions.new CoordinateSystem(furtherCoordinates, false);
        junctions.listOfCoordinates.add(baseSystem);
        junctions.listOfCoordinates.add(farSystem);
        junctions.listOfCoordinates.add(nearSystem);
        junctions.listOfCoordinates.add(furtherSystem);
        // Act
        junctions.linkCoordinates();
        // Assert
        long expectedIndexLinkToBase = 2;
        long expectedIndexLinkToNear = 0;
        long expectedIndexLinkToFar = 3;
        assertEquals(expectedIndexLinkToBase, junctions.listOfCoordinates.get(0).indexOfLinked);
        assertEquals(expectedIndexLinkToNear, junctions.listOfCoordinates.get(2).indexOfLinked);
        assertEquals(expectedIndexLinkToFar, junctions.listOfCoordinates.get(1).indexOfLinked);
        int expectedNearJunction = 0;
        int expectedFarJunction = 1;
        assertEquals(expectedNearJunction, junctions.listOfCoordinates.get(0).junction);
        assertEquals(expectedFarJunction, junctions.listOfCoordinates.get(1).junction);
    }
}
