package adventofcode.dayFour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Forklifts {
    public class Position {
        int xAxis;
        int yAxis;
        boolean isPaper;
        int nearbyPaperCount;

        public Position(int xAxis, int yAxis, boolean isPaper) {
            this.xAxis = xAxis;
            this.yAxis = yAxis;
            this.isPaper = isPaper;
        }

        public int getNearbyPaper() {
            return this.nearbyPaperCount;
        }

        public void setNearbyPaper(int value) {
            this.nearbyPaperCount = value;
        }

        public int getX() {
            return this.xAxis;
        }

        public int getY() {
            return this.yAxis;
        }

        public boolean getValue() {
            return this.isPaper;
        }
    }

    public List<Position> grid = new ArrayList<>();

    public List<Position> getPosition() {
        return this.grid;
    }

    public Position getPositionByAxis(int desiredX, int desiredY) {
        return this.grid.stream().filter(x -> x.xAxis == desiredX && x.yAxis == desiredY).toList().get(0);
    }

    public int getAxisMaxX() {
        return Collections.max(this.grid, Comparator.comparing(x -> x.xAxis)).xAxis;
    }

    public int getAxisMaxY() {
        return Collections.max(this.grid, Comparator.comparing(x -> x.yAxis)).yAxis;
    }

    public Forklifts() {
    };

    public void applyGrid(List<String> input) {
        for (int yIndex = 0; yIndex < input.size(); yIndex++) {
            String line = input.get(yIndex);
            for (int xIndex = 0; xIndex < line.length(); xIndex++) {
                boolean isPaper = (line.charAt(xIndex) == '@');
                grid.add(new Position(xIndex + 1, yIndex + 1, isPaper));
            }
        }
    }

    public void findNearbyPaper(int xAxis, int yAxis) {
        int maxX = getAxisMaxX();
        int maxY = getAxisMaxY();
        int count = 0;
        for (int xSearch = 1; xSearch <= maxX; xSearch++) {
            for (int ySearch = 1; ySearch <= maxY; ySearch++) {
                if (Math.abs(xAxis - ySearch) < 2 && Math.abs(yAxis - xSearch) < 2) {
                    if (xSearch == xAxis && yAxis == ySearch) {
                        continue;
                    } else {
                        if (getPositionByAxis(xSearch, ySearch).getValue()) {
                            count += 1;
                        }
                    }
                }
            }
        }
        this.getPositionByAxis(xAxis, yAxis).setNearbyPaper(count);
    }
}
