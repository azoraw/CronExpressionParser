package azoraw;

import static java.lang.Integer.parseInt;

public class FromToStrategy implements ParsingStrategy {
    @Override
    public boolean canProcess(String input) {
        return input.contains("-");
    }

    @Override
    public String process(String input, CronRule cronRule) {
        final String[] split = input.split("-");
        int from = parseInt(split[0]);
        int to = parseInt(split[1]);
        validate(from, to, cronRule);
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = from; i <= to; i++) {
            stringBuilder.append(i);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private void validate(int from, int to, CronRule cronRule) {
        if (from > to || from < cronRule.getMin() || to > cronRule.getMax()) {
            throw new IllegalArgumentException("Numbers out of bounds");
        }
    }
}
