package adventofcode.dayEight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Junctions {
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

    }

    public class CoordinateSystem {
        public Coordinates coordinates;
        public boolean linked;
        public int indexOfLinked = -1;
        public int junction = -1;

        public CoordinateSystem(Coordinates coordinates, boolean linked) {
            this.coordinates = coordinates;
            this.linked = linked;
        }

        public Coordinates getCoordinates() {
            return coordinates;
        }

        public boolean getLinked() {
            return linked;
        }
        
        public void setLinked(boolean isLinked) {
            linked = isLinked;
        }

        public int getIndexOfLinked() {
            return indexOfLinked;
        }
        
        public int getJunction() {
            return junction;
        }
        
        public void setJunction(int newJunction) {
            junction = newJunction;
        }

        public void findClosest(List<CoordinateSystem> listOfCoordinates, int junctionCounter) {
            HashMap<Integer, Double> indexToDistanceMap = new HashMap<>();
            for (int i = 0; i < listOfCoordinates.size(); i++) {
                CoordinateSystem coordinateSystem = listOfCoordinates.get(i);
                if (coordinates.isEqualTo(coordinateSystem.coordinates)) {
                    continue;
                } else {
                    indexToDistanceMap.put(i, coordinates.distanceTo(coordinateSystem.coordinates));
                }
            }
            linked = true;
            indexOfLinked = indexToDistanceMap.entrySet().stream().min(Comparator.comparingDouble(Map.Entry::getValue))
                    .orElse(null).getKey();
            CoordinateSystem linkedCoordinate = listOfCoordinates.get(indexOfLinked);
            linkedCoordinate.setLinked(true);
        }
    }

    public List<CoordinateSystem> listOfCoordinates = new ArrayList<>();

    public void linkCoordinates() {
        int junctionCounter = 0;
        for (CoordinateSystem coordinateSystem : listOfCoordinates) {
            coordinateSystem.findClosest(listOfCoordinates, junctionCounter);
            CoordinateSystem linkedCoordinate = listOfCoordinates.get(coordinateSystem.getIndexOfLinked());
            if (linkedCoordinate.getIndexOfLinked() >= 0) {
                coordinateSystem.setJunction(linkedCoordinate.junction);
            } else {
                linkedCoordinate.setJunction(junctionCounter);
                coordinateSystem.setJunction(junctionCounter);
                junctionCounter++;
            }
        }
    }
}
