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
    public void canDoNegativeRotation() {
        state.rotate(-15);
        int expectedRotation = 85;
        assertEquals(expectedRotation, state.getPosition());
    }

    @Test
    public void canDoRotationByOver100() {
        state.rotate(101);
        int expectedRotation = 1;
        assertEquals(expectedRotation, state.getPosition());
    }
    
    @Test
    public void canDoNegativeRotationByOver100() {
        state.rotate(-401);
        int expectedRotation = 99;
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

    @Test
    public void canHandleRightRotation() {
        state.input("R20");
        int expectedRotation = 20;
        assertEquals(expectedRotation, state.getPosition());
    }
    
    @Test
    public void canHandleLeftRotation() {
        state.input("L20");
        int expectedRotation = 80;
        assertEquals(expectedRotation, state.getPosition());
    }

    @Test
    public void canReadFileOfRotations() {
        state.readRotations("test");
        int expectedRotation = 20;
        assertEquals(expectedRotation, state.getPosition());
    }
}
