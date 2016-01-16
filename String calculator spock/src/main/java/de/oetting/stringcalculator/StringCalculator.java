package de.oetting.stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String input) {
        if (input.equals(""))
            return 0;
        if (inputStartsWithCustomDelimiter(input))
            return sumWithCustomDelimiter(input);
        return sum(input);
    }

    private int sumWithCustomDelimiter(String input) {
        int indexOfFirstNewline = input.indexOf('\n');
        String delimiter = input.substring("//".length(), indexOfFirstNewline);
        return sum(input.substring(indexOfFirstNewline + 1), delimiter);
    }

    private int sum(String input, String delimiter) {
        String[] numbers = input.split("[,\n" + delimiter + "]");
        int sum = 0;
        List<String> negativeNumbers = new ArrayList<String>();
        for (String number: numbers) {
            int value = Integer.parseInt(number);
            if (value < 0)
                negativeNumbers.add(number);
            sum += value;
        }
        if (!negativeNumbers.isEmpty())
            throw new NegativeNumberException(negativeNumbers.toString());
        return sum;
    }

    private boolean inputStartsWithCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private int sum(String input) {
       return sum(input, "");
    }

}
