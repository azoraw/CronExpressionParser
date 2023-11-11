package azoraw;

class NumericParser {

    String parseMinute(String input) {
        return parseStar(CronRule.MINUTE);
    }
    String parseHour(String input) {
        return parseStar(CronRule.HOUR);
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


    private static String parseStar(CronRule cronRule) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = cronRule.getMin(); i <= cronRule.getMax(); i++) {
            stringBuilder.append(i);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
