package azoraw;

import static java.lang.Integer.parseInt;

class NumericParser {

    String parseMinute(String input) {
        //return parseStar(CronRule.MINUTE);
        return parseFromTo(input);
    }

    String parseHour(String input) {
        return parseComma(input);
    }

    String parsDayOfMonth(String input) {
        return parseStar(CronRule.DAY_OF_MONTH);
    }

    String parseMonth(String input) {
        return parseStar(CronRule.MONTH);
    }

    String parseDayOfWeek(String input) {
        return parseStar(CronRule.DAY_OF_WEEK);
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
