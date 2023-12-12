package menu.model;

import static menu.constant.ErrorMessage.INVALID_COACH_NAME;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Coaches implements Iterator<Coach> {

    public static final String SEPARATOR = ",";
    public static final int MIN_COACH_LENGTH = 2;
    public static final int MAX_COACH_LENGTH = 5;

    private final List<Coach> coaches;
    private Iterator<Coach> iterator;

    private Coaches(List<Coach> coaches) {
        if (Set.copyOf(coaches).size() != coaches.size()) {
            throw new IllegalArgumentException(INVALID_COACH_NAME.getMessage());
        }
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

    private static void validate(String value) {
        validateNull(value);
        validateSeparator(value);
        validateLength(value);

    }

    private static void validateLength(String value) {
        int length = value.trim().split(SEPARATOR).length;
        if (MIN_COACH_LENGTH > length || MAX_COACH_LENGTH < length) {
            throw new IllegalArgumentException(INVALID_COACH_NAME.getMessage());
        }
    }

    private static void validateNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException(INVALID_COACH_NAME.getMessage());
        }
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_COACH_NAME.getMessage());
        }
    }

    private static void validateSeparator(String value) {
        if (value.startsWith(SEPARATOR)) {
            throw new IllegalArgumentException(INVALID_COACH_NAME.getMessage());
        }
        if (value.endsWith(SEPARATOR)) {
            throw new IllegalArgumentException(INVALID_COACH_NAME.getMessage());
        }
        if (value.contains(SEPARATOR.repeat(2))) {
            throw new IllegalArgumentException(INVALID_COACH_NAME.getMessage());
        }
    }

    public void initIterator() {
        iterator = coaches.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Coach next() {
        return iterator.next();
    }
}
