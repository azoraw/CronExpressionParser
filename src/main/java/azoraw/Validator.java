package azoraw;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@UtilityClass
class Validator {

    static void validateBounds(String[] numbers, CronRule cronRule) {
        List<Integer> intList = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();

        int max = Collections.max(intList);
        int min = Collections.min(intList);

        if (max > cronRule.getMax() || min < cronRule.getMin()) {
            throw new IllegalArgumentException("Numbers out of bounds");
        }
    }
}
