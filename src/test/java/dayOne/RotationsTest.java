package dayOne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;


import adventofcode.dayOne.Rotations;

public class RotationsTest {
    Rotations state;
    @BeforeEach
    public void setUpState() {
        state = new Rotations(0);
    }

    @Test
    public void canDoZeroRotation() {
        state.rotate(0);
        int expectedRotation = 0;
        assertEquals(expectedRotation, state.getPosition());
    }

    @Test
    public void canDoRotationByOne() {
        state.rotate(1);
        int expectedRotation = 1;
        assertEquals(expectedRotation, state.getPosition());
    }

    @Test
    public void canDoRotationByOver100() {
        state.rotate(101);
        int expectedRotation = 1;
        assertEquals(expectedRotation, state.getPosition());
    }
    
    @Test
    public void canDoMultipleRotations() {
        state.rotate(1);
        state.rotate(1);
        state.rotate(1);
        int expectedRotation = 3;
        assertEquals(expectedRotation, state.getPosition());
    }
}
