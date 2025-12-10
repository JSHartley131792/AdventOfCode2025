package dayEight;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventofcode.dayEight.Junctions;
import adventofcode.dayEight.Junctions.CoordinateSystem;
import adventofcode.dayEight.Junctions.Coordinates;

public class JunctionsTest {
    Junctions junctions;
    String testInput = "162,817,812\n" +
            "57,618,57\n" +
            "906,360,560\n" +
            "592,479,940\n" +
            "352,342,300\n" +
            "466,668,158\n" +
            "542,29,236\n" +
            "431,825,988\n" +
            "739,650,466\n" +
            "52,470,668\n" +
            "216,146,977\n" +
            "819,987,18\n" +
            "117,168,530\n" +
            "805,96,715\n" +
            "346,949,466\n" +
            "970,615,88\n" +
            "941,993,340\n" +
            "862,61,35\n" +
            "984,92,344\n" +
            "425,690,689";
    List<String> input = Arrays.stream(testInput.split("\\n")).toList();

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

    @Test
    public void canFindClosestPairInSystem() {
        // arrange
        for (String coordinateString : input) {
            String[] split = coordinateString.split(",");
            Coordinates coordinates = junctions.new Coordinates(Integer.valueOf(split[0]), Integer.valueOf(split[1]),
                    Integer.valueOf(split[2]));
            CoordinateSystem coordinateSystem = junctions.new CoordinateSystem(coordinates, false);
            junctions.listOfCoordinates.add(coordinateSystem);
        }
        // act
        // assert
        CoordinateSystem systemOne = junctions.new CoordinateSystem(junctions.new Coordinates(162, 817, 812), false);
        CoordinateSystem systemTwo = junctions.new CoordinateSystem(junctions.new Coordinates(425, 690, 689), false);
        assertEquals(systemOne.coordinates.getX(), junctions.findClosestPairWithinList().getStartingCoord().coordinates.getX());
        assertEquals(systemOne.coordinates.getY(), junctions.findClosestPairWithinList().getStartingCoord().coordinates.getY());
        assertEquals(systemOne.coordinates.getZ(), junctions.findClosestPairWithinList().getStartingCoord().coordinates.getZ());
        assertEquals(systemTwo.coordinates.getX(), junctions.findClosestPairWithinList().getEndingCoord().coordinates.getX());
        assertEquals(systemTwo.coordinates.getY(), junctions.findClosestPairWithinList().getEndingCoord().coordinates.getY());
        assertEquals(systemTwo.coordinates.getZ(), junctions.findClosestPairWithinList().getEndingCoord().coordinates.getZ());
    }
}
