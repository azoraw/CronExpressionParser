package azoraw.strategy;

import azoraw.CronField;

import static java.lang.Integer.parseInt;

class FromToStrategy implements ParsingStrategy {
    @Override
    public boolean canProcess(String input) {
        return input.contains("-");
    }

    @Override
    public String process(String input, CronField cronField) {
        final String[] split = input.split("-");
        int from = parseInt(split[0]);
        int to = parseInt(split[1]);
        validate(from, to, cronField);
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = from; i <= to; i++) {
            stringBuilder.append(i);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private void validate(int from, int to, CronField cronField) {
        if (from > to || from < cronField.getMin() || to > cronField.getMax()) {
            throw new IllegalArgumentException("Numbers out of bounds");
        }
    }
}
