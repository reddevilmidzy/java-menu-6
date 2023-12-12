package menu.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    private final List<String> coaches;

    private Coaches(List<String> coaches) {
        this.coaches = coaches;
    }

    public static Coaches from(String value) {

        List<String> coaches = Arrays.stream(value.split(","))
                .map(String::valueOf)
                .collect(Collectors.toList());
        return new Coaches(coaches);
    }
}
