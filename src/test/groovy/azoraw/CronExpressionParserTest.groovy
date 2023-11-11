package azoraw

import spock.lang.Specification

class CronExpressionParserTest extends Specification {
    def "should be properly formatted"() {
        given:
        def parser = new CronExpressionParser()

        expect:
        "minute        0\n" +
        "hour          0\n" +
        "day of month  1\n" +
        "month         1\n" +
        "day of week   0\n" +
        "command       /\n"== parser.parse("0 0 1 1 0 /")
    }
}
