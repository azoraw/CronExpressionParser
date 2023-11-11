package azoraw.strategy;

import azoraw.CronRule;

interface ParsingStrategy {
    boolean canProcess(String input);

    String process(String input, CronRule cronRule);
}
