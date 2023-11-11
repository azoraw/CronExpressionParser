package azoraw;

import static java.lang.Integer.parseInt;

class CronFragmentsParser {

    String parseMinute(String input) {
        return strategy(input, CronRule.MINUTE);
    }

    String parseHour(String input) {
        return strategy(input, CronRule.HOUR);
    }

    String parsDayOfMonth(String input) {
        return strategy(input, CronRule.DAY_OF_MONTH);
    }

    String parseMonth(String input) {
        return strategy(input, CronRule.MONTH);
    }

    String parseDayOfWeek(String input) {
        return strategy(input, CronRule.DAY_OF_WEEK);
    }

    private String strategy(String input, CronRule cronRule) {
        if (isFromTo(input)) {
            return parseFromTo(input);
        } else if (isStar(input)) {
            return parseStar(cronRule);
        } else {
            return parseComma(input);
        }
    }

    private boolean isStar(String input) {
        return input.equals("*");
    }

    private boolean isFromTo(String input) {
        return input.contains("-");
    }

    private static String parseComma(String input) {
        final String[] split = input.split(",");
        final StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            stringBuilder.append(parseInt(s));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private static String parseFromTo(String input) {
        final String[] split = input.split("-");
        int from = parseInt(split[0]);
        int to = parseInt(split[1]);
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = from; i <= to; i++) {
            stringBuilder.append(i);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private static String parseStar(CronRule cronRule) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = cronRule.getMin(); i <= cronRule.getMax(); i++) {
            stringBuilder.append(i);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
