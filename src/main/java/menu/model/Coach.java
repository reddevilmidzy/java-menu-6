package menu.model;

public class Coach {

    private final String name;


    private Coach(String name) {
        this.name = name;
    }

    public static Coach from(String value) {
        validate(value);
        return new Coach(value);
    }

    private static void validate(String value) {
        validateNull(value);
        validateLength(value);
    }

    private static void validateLength(String value) {
        if (value.length() < 2 || value.length() > 4) {
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
}
