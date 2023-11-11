package azoraw;

public class OnlyDigitsStrategy implements ParsingStrategy {
    @Override
    public boolean canProcess(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    @Override
    public String process(String input, CronRule cronRule) {
        return input;
    }
}

