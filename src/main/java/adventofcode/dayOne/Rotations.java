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

    public void input(String inputString) {
        String orientation = inputString.substring(0, 1);
        String rotationString = inputString.substring(1, inputString.length());
        int rotation;
        switch (orientation) {
            case "L":
                rotation = -Integer.parseInt(rotationString);
                break;
            default:
                rotation = Integer.parseInt(rotationString);
                break;
        }
        rotate(rotation);
    }

}
