package dayEight;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventofcode.dayEight.Junctions;
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
    public void canFindDistanceForWholeList() {
        for (String coordinateString : input) {
            String[] split = coordinateString.split(",");
            Coordinates coordinates = junctions.new Coordinates(Integer.valueOf(split[0]), Integer.valueOf(split[1]),
                    Integer.valueOf(split[2]));
            junctions.listOfCoordinates.add(coordinates);
        }
        Coordinates expectedShortestOne = junctions.new Coordinates(162, 817, 812);
        Coordinates expectedShortestTwo = junctions.new Coordinates(425, 690, 689);
        junctions.computeDistances();
        assertEquals(expectedShortestOne.getX(), junctions.listOfDistances.get(0).getStartingCoord().getX());
        assertEquals(expectedShortestOne.getY(), junctions.listOfDistances.get(0).getStartingCoord().getY());
        assertEquals(expectedShortestOne.getZ(), junctions.listOfDistances.get(0).getStartingCoord().getZ());
        assertEquals(expectedShortestTwo.getX(), junctions.listOfDistances.get(0).getEndingCoord().getX());
        assertEquals(expectedShortestTwo.getY(), junctions.listOfDistances.get(0).getEndingCoord().getY());
        assertEquals(expectedShortestTwo.getZ(), junctions.listOfDistances.get(0).getEndingCoord().getZ());
    }

    @Test
    public void canSolveForPartOne() {
        junctions.solveForPartOne(input);
        long expectedResponse = 40;
        assertEquals(expectedResponse, junctions.totalForPartOne);
    }
}
