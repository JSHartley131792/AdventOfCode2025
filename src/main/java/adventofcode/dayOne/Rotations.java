package adventofcode.dayOne;

public class Rotations {
    int position;
    int dialMax = 100;

    public Rotations(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void rotate(int i) {
        position = (position + i) % dialMax;  
        while (position < 0) {
            position += dialMax;
        }
    }

}
