package adventofcode.dayFour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Forklifts {
    public class Position {
        int xAxis;
        int yAxis;
        boolean isPaper;
        int nearbyPaperCount;
        boolean canAccess;

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

        public void setValue(boolean override) {
            this.isPaper = override;
        }

        public void setCanAccess() {
            this.canAccess = this.isPaper && this.nearbyPaperCount < 4;
        }

        public boolean getCanAccess() {
            return this.isPaper && this.nearbyPaperCount < 4;
        }
    }

    public List<Position> grid = new ArrayList<>();

    public List<Position> gridOfPaper = new ArrayList<>();

    public long removedPaper = 0;

    public long removedInOneGo;

    public List<Position> getPosition() {
        return this.grid;
    }

    public Position getPositionByAxis(int desiredX, int desiredY) {
        return this.grid.stream().filter(x -> x.xAxis == desiredX && x.yAxis == desiredY).toList().get(0);
    }

    public Position getPositionOfPaperByAxis(int desiredX, int desiredY) {
        return this.gridOfPaper.stream().filter(x -> x.xAxis == desiredX && x.yAxis == desiredY).toList().get(0);
    }

    public int getAxisMaxX() {
        return Collections.max(this.grid, Comparator.comparing(x -> x.xAxis)).xAxis;
    }

    public int getAxisMaxY() {
        return Collections.max(this.grid, Comparator.comparing(x -> x.yAxis)).yAxis;
    }

    public long getTotalAccess() {
        return this.grid.stream().filter(x -> x.canAccess == true).count();
    }

    public Forklifts() {
    };

    public void applyGrid(List<String> input) {
        for (int yIndex = 0; yIndex < input.size(); yIndex++) {
            String line = input.get(yIndex);
            for (int xIndex = 0; xIndex < line.length(); xIndex++) {
                boolean isPaper = (line.charAt(xIndex) == '@');
                Position position = new Position(xIndex, yIndex, isPaper);
                grid.add(position);
                if (isPaper)
                    gridOfPaper.add(position);
            }
        }
        for (Position position : gridOfPaper) {
            findNearbyPaper(position.xAxis, position.yAxis);
            position.setCanAccess();
        }
    }

    public void findNearbyPaper(int xAxis, int yAxis) {
        int maxX = getAxisMaxX();
        int maxY = getAxisMaxY();
        int count = 0;
        for (int xSearch = xAxis - 1; xSearch <= xAxis + 1; xSearch++) {
            for (int ySearch = yAxis - 1; ySearch <= yAxis + 1; ySearch++) {
                if (Math.abs(xAxis - xSearch) < 2 && Math.abs(yAxis - ySearch) < 2) {
                    if (xSearch == xAxis && yAxis == ySearch) {
                        continue;
                    } else if (xSearch < 0 || xSearch > maxX || ySearch < 0 || ySearch > maxY) {
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

    public void readForklifts(String env, String fileName) {
        List<String> strings = new ArrayList<>();
        File forkliftsFile = new File("src/" + env + "/resources/dayFour/" + fileName + ".txt");
        try (Scanner myReader = new Scanner(forkliftsFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // System.out.println(data);
                strings.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        applyGrid(strings);
    }

    public void removeAccessible() {
        long removed = gridOfPaper.stream().filter(x -> x.canAccess).count();
        removedPaper += removed;
        removedInOneGo = removed;
        List<Position> gridToRemove = gridOfPaper.stream().filter(x -> x.canAccess).toList();
        gridOfPaper.removeIf(x -> x.canAccess);
        for (Position position : gridToRemove) {
            position.setValue(false);
        }
    }

    public void evaluateGrid() {
        for (Position position : grid) {
            findNearbyPaper(position.xAxis, position.yAxis);
        }
        for (Position position : grid) {
            position.setCanAccess();
        }
    }

    public void reEvaluateGrid() {
        long hasAccessible = gridOfPaper.stream().filter(x -> x.canAccess).count();
        long counter = 0;
        while (hasAccessible > 0) {
            counter +=1;
            removeAccessible();
            evaluateGrid();
            hasAccessible = gridOfPaper.stream().filter(x -> x.canAccess).count();
            System.out.println(counter);
        }
    }
}
