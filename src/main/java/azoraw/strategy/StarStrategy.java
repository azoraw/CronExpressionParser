package azoraw.strategy;

import azoraw.CronField;

class StarStrategy implements ParsingStrategy {
    @Override
    public boolean canProcess(String input) {
        return input.equals("*");
    }

    @Override
    public String process(String input, CronField cronField) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = cronField.getMin(); i <= cronField.getMax(); i++) {
            stringBuilder.append(i);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
