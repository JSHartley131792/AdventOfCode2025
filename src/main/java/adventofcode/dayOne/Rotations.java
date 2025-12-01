package adventofcode.dayOne;

public class Rotations {
    int position;

    public Rotations(int position) {
        this.position = position;
    }

    public int rotate(int i) {
        return (position + i) % 100;
    }

}
