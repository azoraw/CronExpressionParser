package azoraw.strategy;

import azoraw.CronField;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

class CommaStrategy implements ParsingStrategy {
    @Override
    public boolean canProcess(String input) {
        return input.contains(",");
    }

    @Override
    public String process(String input, CronField cronField) {
        final String[] split = input.split(",");
        validate(split, cronField);
        final StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            stringBuilder.append(parseInt(s));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private void validate(String[] numbers, CronField cronField) {
        validateBounds(numbers, cronField);
    }

    private void validateBounds(String[] numbers, CronField cronField) {
        List<Integer> intList = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();

        int max = Collections.max(intList);
        int min = Collections.min(intList);

        if (max > cronField.getMax() || min < cronField.getMin()) {
            throw new IllegalArgumentException("Numbers out of bounds");
        }
    }
}

