package adventofcode.dayOne;

public class Rotations {

    public static int rotate(int i) {
        int startingPosition = 0;
        return (startingPosition + i) % 100;
    }
    
}
