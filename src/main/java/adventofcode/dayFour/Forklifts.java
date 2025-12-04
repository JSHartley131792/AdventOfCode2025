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


    public Forklifts() {};

    public void applyGrid(String input) {
        for (int i = 0; i < input.length(); i++) {
            boolean isPaper = (input.charAt(i) == '@');
            grid.add(new Position(i+1, 1, isPaper));
        }
    }
}
