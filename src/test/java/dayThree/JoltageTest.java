package dayThree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import adventofcode.dayThree.Joltage;

public class JoltageTest {
    Joltage joltage;
    @BeforeEach
    void setUp() {
        joltage = new Joltage();
    }

    @Test
    public void canSplitIntIntoDigits() {
        int sectionSize = 1;
        String startingString = "012";
        List<Integer> sections = joltage.splitIntIntoDigits(startingString,sectionSize);
        assertEquals(0, sections.get(0));
        assertEquals(1, sections.get(1));
        assertEquals(2, sections.get(2));
    }

    @Test
    public void canFindMaxJoltageWhenInOrder() {
        joltage.findJoltage("987654321");
        int expectedResult = 98;
        assertEquals(expectedResult, joltage.getTotalJoltage());
    }
    
    @Test
    public void canFindMaxJoltageWhenOutOfOrder() {
        joltage.findJoltage("811111111111119");
        int expectedResult = 89;
        assertEquals(expectedResult, joltage.getTotalJoltage());
    }

    @Test
    public void canReadFileOfJoltages() {
        joltage.readJoltages("test", "input");
        int expectedResult = 357;
        assertEquals(expectedResult, joltage.getTotalJoltage());
    }
}
