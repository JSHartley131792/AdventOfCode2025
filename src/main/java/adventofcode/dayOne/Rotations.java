package adventofcode.dayOne;

public class Rotations {
    int position;

    public Rotations(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void rotate(int i) {
        position = (position + i) % 100;
    }

}
