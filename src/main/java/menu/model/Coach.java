package menu.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {

    private final CoachName name;
    private final List<Menu> cannotEat;

    public Coach(CoachName name, List<Menu> cannotEat) {
        this.name = name;
        this.cannotEat = cannotEat;
    }

    public static Coach of(CoachName name, String menus) {
        validate(menus);
        List<Menu> cannotEat = Arrays.stream(menus.split(","))
                .map(Menu::nameOf)
                .collect(Collectors.toList());
        return new Coach(name, cannotEat);
    }

    private static void validate(String value) {
        //TODO: 메뉴에 없는 경우
        //TODO: 최소 0개, 최대 2개의 못먹는 메뉴
        //TODO: 쉼표 위치 확인
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name=" + name +
                ", cannotEat=" + cannotEat +
                '}';
    }
}
