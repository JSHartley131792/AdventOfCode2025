package dayOne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import adventofcode.dayOne.Rotations;

public class RotationsTest {

    @Test
    public void canDoZeroRotation() {
        int result = Rotations.rotate(0);
        int expectedRotation = 0;
        assertEquals(expectedRotation, result);
    }
    
    @Test
    public void canDoRotationByOne() {
        int result = Rotations.rotate(1);
        int expectedRotation = 1;
        assertEquals(expectedRotation, result);
    }
}
