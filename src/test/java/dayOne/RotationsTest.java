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
        state.readRotations("test", "input");
        int expectedRotation = 20;
        assertEquals(expectedRotation, state.getPosition());
    }

    // initial zero counter was only ending at 0
    // new zero counter is anytime it passes 0

    // you're actually supposed to count the number of times 
    // any click causes the dial to point at 0, 
    // regardless of whether it happens during a rotation or at the end of one.

    // @Test
    // public void canKeepTrackOfZeroCounter() {
    //     // different starting position
    //     state = new Rotations(50);

    //     state.readRotations("test", "exampleZeroCounter");
    //     int expectedRotation = 32;
    //     int expectedZeroCounter = 3;
    //     assertEquals(expectedRotation, state.getPosition());
    //     assertEquals(expectedZeroCounter, state.getZeroCounter());
    // }
    
    @Test
    public void canKeepTrackOfZeroCounterInSingleRotation() {
        state = new Rotations(50);
        state.rotate(1000);
        int expectedZeroCounter = 10;
        assertEquals(expectedZeroCounter, state.getZeroCounter());
    }
    
    
    @Test
    public void canKeepTrackOfZeroCounterInSingleNegativeRotation() {
        state = new Rotations(50);
        state.rotate(-1000);
        int expectedZeroCounter = 10;
        assertEquals(expectedZeroCounter, state.getZeroCounter());
    }

    @Test
    public void canKeepTrackOfZeroCounter() {
        // different starting position
        state = new Rotations(50);

        state.readRotations("test", "exampleZeroCounter");
        int expectedRotation = 32;
        int expectedZeroCounter = 6;
        assertEquals(expectedRotation, state.getPosition());
        assertEquals(expectedZeroCounter, state.getZeroCounter());
    }
    
    @Test
    public void canKeepTrackOfZeroCounterInSingleNegativeSmallRotation() {
        state = new Rotations(2);
        state.rotate(-3);
        int expectedRotation = 99;
        int expectedZeroCounter = 1;
        assertEquals(expectedRotation, state.getPosition());
        assertEquals(expectedZeroCounter, state.getZeroCounter());
    }
    
    @Test
    public void canKeepTrackOfZeroCounterInSingleReverseRotation() {
        state = new Rotations(50);
        state.rotate(-50);
        int expectedRotation = 0;
        int expectedZeroCounter = 1;
        assertEquals(expectedRotation, state.getPosition());
        assertEquals(expectedZeroCounter, state.getZeroCounter());
    }
}
