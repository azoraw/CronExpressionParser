package azoraw;

import java.util.List;

class CronNumericParser {

    private final List<ParsingStrategy> strategies = List.of(new CommaStrategy(), new FromToStrategy(), new StarStrategy(), new OnlyDigitsStrategy());

    String parse(String input, CronRule cronRule) {
       return strategies.stream()
                .filter(strategy -> strategy.canProcess(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No parsing strategy found for given input"))
                .process(input, cronRule);
    }

}
