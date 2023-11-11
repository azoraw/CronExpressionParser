package azoraw;

import static java.lang.Integer.parseInt;

public class OnlyDigitsStrategy implements ParsingStrategy {
    @Override
    public boolean canProcess(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    @Override
    public String process(String input, CronRule cronRule) {
        validate(input, cronRule);
        return input;
    }

    private void validate(String input, CronRule cronRule) {
        final int number = parseInt(input);
        if (number < cronRule.getMin() || number > cronRule.getMax()) {
            throw new IllegalArgumentException("Numbers out of bounds");
        }
    }
}

