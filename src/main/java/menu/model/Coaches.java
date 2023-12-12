package menu.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    public static final String SEPARATOR = ",";
    public static final int MIN_COACH_LENGTH = 2;
    public static final int MAX_COACH_LENGTH = 5;

    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches from(String value) {
        validate(value);
        List<Coach> coaches = Arrays.stream(value.split(SEPARATOR))
                .map(String::valueOf)
                .map(Coach::from)
                .collect(Collectors.toList());
        return new Coaches(coaches);
    }

    public List<Coach> getCoaches() {
        return coaches;
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
        if (value.trim().isEmpty()) {
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
