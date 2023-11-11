package azoraw.strategy;

import azoraw.CronRule;

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
    public String process(String input, CronRule cronRule) {
        final String[] split = input.split(",");
        validate(split, cronRule);
        final StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            stringBuilder.append(parseInt(s));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private void validate(String[] numbers, CronRule cronRule) {
        validateBounds(numbers, cronRule);
    }

    private void validateBounds(String[] numbers, CronRule cronRule) {
        List<Integer> intList = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();

        int max = Collections.max(intList);
        int min = Collections.min(intList);

        if (max > cronRule.getMax() || min < cronRule.getMin()) {
            throw new IllegalArgumentException("Numbers out of bounds");
        }
    }
}

