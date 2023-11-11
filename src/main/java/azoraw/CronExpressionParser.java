package azoraw;

public class CronExpressionParser {

    private static final int KEYS_LENGTH = 14;
    private static final String MINUTE = "minute";
    private static final String HOUR = "hour";
    private static final String DAY_OF_MONTH = "day of month";
    private static final String MONTH = "month";
    private static final String DAY_OF_WEEK = "day of week";
    private static final String COMMAND = "command";

    private final StringBuilder outputBuilder;

    public CronExpressionParser() {
        outputBuilder = new StringBuilder();
    }

    String parse(String input) {
        addLine(MINUTE, "0");
        addLine(HOUR, "0");
        addLine(DAY_OF_MONTH, "1");
        addLine(MONTH, "1");
        addLine(DAY_OF_WEEK, "0");
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