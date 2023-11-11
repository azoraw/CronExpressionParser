package azoraw.strategy;

import azoraw.CronRule;

import java.util.List;

public class CronNumericParser {

    private final List<ParsingStrategy> strategies = List.of(new CommaStrategy(), new FromToStrategy(), new StarStrategy(), new OnlyDigitsStrategy());

    public String parse(String input, CronRule cronRule) {
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
