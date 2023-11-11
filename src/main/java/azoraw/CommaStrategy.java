package azoraw;

import static java.lang.Integer.parseInt;

public class CommaStrategy implements ParsingStrategy {
    @Override
    public boolean canProcess(String input) {
        return input.contains(",");
    }

    @Override
    public String process(String input, CronRule cronRule) {
        final String[] split = input.split(",");
        final StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            stringBuilder.append(parseInt(s));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}

