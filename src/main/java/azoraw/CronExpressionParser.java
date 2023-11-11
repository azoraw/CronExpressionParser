package azoraw;

class CronExpressionParser {

    private static final int KEYS_LENGTH = 14;
    private static final String MINUTE = "minute";
    private static final String HOUR = "hour";
    private static final String DAY_OF_MONTH = "day of month";
    private static final String MONTH = "month";
    private static final String DAY_OF_WEEK = "day of week";
    private static final String COMMAND = "command";

    private final CronNumericParser cronNumericParser;
    private final StringBuilder outputBuilder;

    CronExpressionParser() {
        cronNumericParser = new CronNumericParser();
        outputBuilder = new StringBuilder();
    }

    String parse(String input) {
        final String[] splitInput = input.split(" ");

        addLine(MINUTE, cronNumericParser.parse(splitInput[0], CronRule.MINUTE));
        addLine(HOUR, cronNumericParser.parse(splitInput[1], CronRule.HOUR));
        addLine(DAY_OF_MONTH, cronNumericParser.parse(splitInput[2], CronRule.DAY_OF_MONTH));
        addLine(MONTH, cronNumericParser.parse(splitInput[3], CronRule.MONTH));
        addLine(DAY_OF_WEEK, cronNumericParser.parse(splitInput[4], CronRule.DAY_OF_WEEK));
        addLine(COMMAND, "/");
        return outputBuilder.toString();
    }

    private void addLine(String key, String value) {
        StringBuilder keyBuilder = new StringBuilder(key);
        while (keyBuilder.length() < KEYS_LENGTH) {
            keyBuilder.append(" ");
        }
        outputBuilder.append(keyBuilder)
                .append(value)
                .append("\n");
    }
}