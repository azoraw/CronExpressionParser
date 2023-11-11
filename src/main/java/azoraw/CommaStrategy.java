package azoraw;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static azoraw.Validator.validateBounds;
import static java.lang.Integer.parseInt;

public class CommaStrategy implements ParsingStrategy {
    @Override
    public boolean canProcess(String input) {
        return input.contains(",");
    }

    @Override
    public String process(String input, CronRule cronRule) {
        final String[] split = input.split(",");
        validate(split, cronRule);
        final StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            stringBuilder.append(parseInt(s));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private void validate(String[] numbers, CronRule cronRule) {
        validateBounds(numbers, cronRule);
    }
}

