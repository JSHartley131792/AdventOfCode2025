package adventofcode.dayFour;

import java.util.ArrayList;
import java.util.List;

public class Forklifts {
    public class Position {
        int xAxis;
        int yAxis;
        boolean isPaper;

        public Position(int xAxis, int yAxis, boolean isPaper) {
            this.xAxis = xAxis;
            this.yAxis = yAxis;
            this.isPaper = isPaper;
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
}
