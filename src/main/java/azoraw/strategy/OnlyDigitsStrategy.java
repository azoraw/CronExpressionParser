package azoraw.strategy;

import azoraw.CronField;

import static java.lang.Integer.parseInt;

class OnlyDigitsStrategy implements ParsingStrategy {
    @Override
    public boolean canProcess(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    @Override
    public String process(String input, CronField cronField) {
        validate(input, cronField);
        return input;
    }

    private void validate(String input, CronField cronField) {
        final int number = parseInt(input);
        if (number < cronField.getMin() || number > cronField.getMax()) {
            throw new IllegalArgumentException("Numbers out of bounds");
        }
    }
}

