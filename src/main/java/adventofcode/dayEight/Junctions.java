package adventofcode.dayEight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Junctions {
    public long totalForPartOne;

    public class Coordinates {
        long x;
        long y;
        long z;

        public Coordinates(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double distanceTo(Coordinates valueCoordinates) {
            return Math.sqrt((Math.pow((x - valueCoordinates.x), 2) +
                    Math.pow((y - valueCoordinates.y), 2) +
                    Math.pow((z - valueCoordinates.z), 2)));
        }

        public boolean isEqualTo(Coordinates coordinates) {
            return x == coordinates.x && y == coordinates.y && z == coordinates.z;
        }

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
        }

        public long getZ() {
            return z;
        }

    }

    public class CoordinateDistance {
        Coordinates startingCoordinate;
        Coordinates endingCoordinate;
        Double distance;

        public CoordinateDistance(Coordinates systemOne, Coordinates systemTwo, Double dist) {
            this.startingCoordinate = systemOne;
            this.endingCoordinate = systemTwo;
            this.distance = dist;
        }

        public Coordinates getStartingCoord() {
            return startingCoordinate;
        }

        public Coordinates getEndingCoord() {
            return endingCoordinate;
        }

        public Double getDistance() {
            return distance;
        }
    }

    public List<Coordinates> listOfCoordinates = new ArrayList<>();
    public ArrayList<CoordinateDistance> listOfDistances = new ArrayList<>();
    public List<Set<Coordinates>> junctions = new ArrayList<>();

    public Set<Integer> setOfJunctions = new HashSet<>();

    public void computeDistances() {
        final int numberOfPoints = listOfCoordinates.size();
        for (int i = 0; i < numberOfPoints; i++) {
            for (int j = i + 1; j < numberOfPoints; j++) {
                Coordinates coordOne = listOfCoordinates.get(i);
                Coordinates coordTwo = listOfCoordinates.get(j);
                listOfDistances.add(new CoordinateDistance(coordOne,coordTwo, coordOne.distanceTo(coordTwo)));
            }
        }
        listOfDistances.sort(Comparator.comparingDouble(CoordinateDistance::getDistance));
    }

    public void linkCoordinates(int limit) {
        List<CoordinateDistance> shortestDistances = listOfDistances.subList(0, limit);
        for (CoordinateDistance distance : shortestDistances) {
            List<Set<Coordinates>> matchingJunctions = junctions.stream()
                    .filter(c -> c.contains(distance.startingCoordinate) || c.contains(distance.endingCoordinate))
                    .toList();
            if (matchingJunctions.isEmpty()) {
                Set<Coordinates> junction = new HashSet<>();
                junction.add(distance.endingCoordinate);
                junction.add(distance.startingCoordinate);
                junctions.add(junction);
            } else if (matchingJunctions.size() == 1) {
                final Set<Coordinates> junction = matchingJunctions.getFirst();
                junction.add(distance.startingCoordinate);
                junction.add(distance.endingCoordinate);
            } else if (matchingJunctions.size() == 2) {
                matchingJunctions.getFirst()
                        .addAll(matchingJunctions.getLast());
                if (!junctions.remove(matchingJunctions.getLast())) {
                    throw new IllegalStateException("failed to remove circuit");
                }
            }
        }
    }

    public void solveForPartOne(List<String> input) {
        for (String coordinateString : input) {
            String[] split = coordinateString.split(",");
            Coordinates coordinates = new Coordinates(Integer.valueOf(split[0]), Integer.valueOf(split[1]),
                    Integer.valueOf(split[2]));
            listOfCoordinates.add(coordinates);
        }
        computeDistances();
        linkCoordinates(listOfCoordinates.size() / 2);
        final List<Integer> sortedSizes = junctions.stream()
                .map(Set::size)
                .sorted((a, b) -> b - a)
                .toList();
        totalForPartOne = (long) sortedSizes.get(0) * sortedSizes.get(1) * sortedSizes.get(2);
    }
}
