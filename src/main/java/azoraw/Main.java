package azoraw;

public class Main {
    public static void main(String[] args) {
        final CronExpressionParser cronExpressionParser = new CronExpressionParser();
        //final String parsedExpression = cronExpressionParser.parse(args[0]);
        final String parsedExpression = cronExpressionParser.parse("2-4 * * * * /");
        System.out.println(parsedExpression);
    }
}