package azoraw;

import java.util.List;

class CronNumericParser {

    private final List<ParsingStrategy> strategies = List.of(new CommaStrategy(), new FromToStrategy(), new StarStrategy(), new OnlyDigitsStrategy());

    String parse(String input, CronRule cronRule) {
        return findOneStrategy(input)
                .process(input, cronRule);
    }

    private ParsingStrategy findOneStrategy(String input) {
        return strategies.stream()
                .filter(strategy -> strategy.canProcess(input))
                .reduce((s1, s2) -> {
                    throw new IllegalArgumentException("Multiple parsing strategies found for given input");
                })
                .orElseThrow(() -> new IllegalArgumentException("No parsing strategy found for given input"));
    }
}
