package adventofcode.daySix;

import java.util.List;

public class Cephalopod {
    public Cephalopod() {

    }

    public String[] parseLine(String string) {
        return string.split("\\s+");
    }

    public Long solve(List<String> input) {
        long sum = 0L;
        String[][] numStrings = new String[input.size() - 1][];
        for (int i = 0; i < input.size() - 1; i++) {
            numStrings[i] = parseLine(input.get(i));
        }
        String[] operationsStrings = parseLine(input.get(input.size() - 1));
        for (int i = 0; i < operationsStrings.length; i++) {
            long line = 0;
            if (operationsStrings[i].equals("+")) {
                for (String[] number : numStrings) {
                    line += Integer.parseInt(number[i]);
                }
            } else {
                line = 1;
                for (String[] number : numStrings) {
                    line *= Integer.parseInt(number[i]);
                }
            }
            sum += line;
        }
        return sum;
    }

}
