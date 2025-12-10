package adventofcode.dayEight;

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
            return Math.sqrt((
                Math.pow((x - valueCoordinates.x), 2) +
                Math.pow((y - valueCoordinates.y), 2) +
                Math.pow((z - valueCoordinates.z), 2)
            ));
        }

    }
}
