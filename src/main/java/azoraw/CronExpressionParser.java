package azoraw;

class CronExpressionParser {

    private static final int KEYS_LENGTH = 14;
    private static final String MINUTE = "minute";
    private static final String HOUR = "hour";
    private static final String DAY_OF_MONTH = "day of month";
    private static final String MONTH = "month";
    private static final String DAY_OF_WEEK = "day of week";
    private static final String COMMAND = "command";

    private final NumericParser numericParser;
    private final StringBuilder outputBuilder;

    CronExpressionParser() {
        numericParser = new NumericParser();
        outputBuilder = new StringBuilder();
    }

    String parse(String input) {
        final String[] splitInput = input.split(" ");

        addLine(MINUTE, numericParser.parseMinute(splitInput[0]));
        addLine(HOUR, numericParser.parseHour(splitInput[1]));
        addLine(DAY_OF_MONTH, numericParser.parsDayOfMonth(splitInput[2]));
        addLine(MONTH, numericParser.parseMonth(splitInput[3]));
        addLine(DAY_OF_WEEK, numericParser.parseDayOfWeek(splitInput[4]));
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