package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DEFAULT_VALUE = 0;
    public static final int CUSTOM_DELIMITER_INDEX = 1;
    public static final int TOKENS_INDEX = 2;

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private StringAddCalculator() {
        throw new IllegalStateException(StringAddCalculator.class.getName() + " Cannot be instantiated");
    }

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return DEFAULT_VALUE;
        }

        String[] tokens = text.split(DEFAULT_DELIMITER);
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
            tokens = matcher.group(TOKENS_INDEX).split(customDelimiter);
        }

        return sum(tokens);
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .map(NaturalNumber::new)
                .mapToInt(NaturalNumber::getNumber)
                .sum();
    }
}