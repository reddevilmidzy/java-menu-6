package menu.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    public static final String SEPARATOR = ",";
    public static int MIN_COACH_LENGTH = 2;
    public static int MAX_COACH_LENGTH = 5;

    private final List<String> coaches;

    private Coaches(List<String> coaches) {
        this.coaches = coaches;
    }

    public static Coaches from(String value) {
        validate(value);
        List<String> coaches = Arrays.stream(value.split(SEPARATOR))
                .map(String::valueOf)
                .collect(Collectors.toList());
        return new Coaches(coaches);
    }

    private static void validate(String value) {
        validateNull(value);
        validateSeparator(value);
        validateLength(value);

    }

    private static void validateLength(String value) {
        int length = value.trim().split(SEPARATOR).length;
        if (MIN_COACH_LENGTH > length || MAX_COACH_LENGTH < length) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }
        if (value.trim().equals("") || value.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSeparator(String value) {
        if (value.startsWith(SEPARATOR)) {
            throw new IllegalArgumentException();
        }
        if (value.endsWith(SEPARATOR)) {
            throw new IllegalArgumentException();
        }
        if (value.contains(SEPARATOR.repeat(2))) {
            throw new IllegalArgumentException();
        }
    }
}
