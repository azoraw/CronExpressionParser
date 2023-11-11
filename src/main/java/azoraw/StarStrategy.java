package azoraw;

public class StarStrategy implements ParsingStrategy {
    @Override
    public boolean canProcess(String input) {
        return input.equals("*");
    }

    @Override
    public String process(String input, CronRule cronRule) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = cronRule.getMin(); i <= cronRule.getMax(); i++) {
            stringBuilder.append(i);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
