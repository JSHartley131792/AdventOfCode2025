package dayThree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import adventofcode.dayThree.Joltage;

public class JoltageTest {

    @Test
    public void canSplitIntIntoDigits() {
        int sectionSize = 1;
        String startingString = "012";
        List<Integer> sections = Joltage.splitIntIntoDigits(startingString,sectionSize);
        assertEquals(0, sections.get(0));
        assertEquals(1, sections.get(1));
        assertEquals(2, sections.get(2));
    }

    @Test
    public void canFindMaxJoltageWhenInOrder() {
        int result = Joltage.findJoltage("987654321");
        int expectedResult = 98;
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void canFindMaxJoltageWhenOutOfOrder() {
        int result = Joltage.findJoltage("811111111111119");
        int expectedResult = 89;
        assertEquals(expectedResult, result);
    }
}
