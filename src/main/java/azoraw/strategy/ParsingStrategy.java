package azoraw.strategy;

import azoraw.CronField;

interface ParsingStrategy {
    boolean canProcess(String input);

    String process(String input, CronField cronField);
}
