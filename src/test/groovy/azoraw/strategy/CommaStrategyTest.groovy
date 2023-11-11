package azoraw.strategy


import spock.lang.Specification

import static azoraw.CronField.DAY_OF_MONTH
import static azoraw.CronField.DAY_OF_WEEK

class CommaStrategyTest extends Specification {

    def '#input should return #canProcess'() {
        given:
        def strategy = new CommaStrategy()

        expect:
        canProcess == strategy.canProcess(input)

        where:
        input   | canProcess
        '1,2,3' | true
        '2,3,5' | true
        '2'     | false
    }

    def '#stringToParse with #cronField should return #parsedString'() {
        given:
        def strategy = new CommaStrategy()

        expect:
        parsedString == strategy.process(stringToParse, cronField)

        where:
        stringToParse | cronField   || parsedString
        '1,2,3'       | DAY_OF_WEEK || '1 2 3 '
        '2,3'         | DAY_OF_WEEK || '2 3 '
        '0,6'         | DAY_OF_WEEK || '0 6 '
    }

    def '#stringToParse should throw exception'() {
        given:
        def strategy = new CommaStrategy()

        when:
        strategy.process(stringToParse, cronField)

        then:
        thrown(IllegalArgumentException)

        where:
        stringToParse | cronField
        '0,1'         | DAY_OF_MONTH
        '31,32'       | DAY_OF_MONTH
        '0,32'        | DAY_OF_MONTH
    }
}
