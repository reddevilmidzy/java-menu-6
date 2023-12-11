package menu.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    private final List<CoachName> coachNames;

    private Coaches(List<CoachName> coachNames) {
        validate(coachNames);
        this.coachNames = coachNames;
    }

    public static Coaches from(String value) {
        validate(value);
        List<CoachName> result = Arrays.stream(value.split(","))
                .map(CoachName::new)
                .collect(Collectors.toList());
        return new Coaches(result);
    }

    private static void validate(String value) {
        //TODO: 쉼표 위치 확인 (제일 처음, 마지막, 중복)
    }

    private void validate(List<CoachName> coachNames) {
        //TODO: 코치 이름 중복 확인
        //TODO: 길이는 최소 2에서 최대 5
    }
}
