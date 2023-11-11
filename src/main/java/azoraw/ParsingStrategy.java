package azoraw;

public interface ParsingStrategy {
    boolean canProcess(String input);
    String process(String input, CronRule cronRule);
}
