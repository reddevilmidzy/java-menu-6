package menu.model;

import static menu.model.Coaches.SEPARATOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coach {

    private final String name;
    private List<Menu> cannotEatMenu;
    private final List<Menu> recommendMenu = new ArrayList<>();


    private Coach(String name) {
        this.name = name;
    }

    public static Coach from(String value) {
        validate(value);
        return new Coach(value);
    }

    //TODO: setter 안쓰는 방법 찾기
    public void setCannotEatMenu(List<Menu> cannotEatMenu) {
        this.cannotEatMenu = cannotEatMenu;
    }

    public boolean canEat(Menu menu) {
        return !cannotEatMenu.contains(menu);
    }

    public void addRecommendMenu(Menu menu) {
        recommendMenu.add(menu);
    }

    public boolean duplicateMenu(Menu menu) {
        return recommendMenu.contains(menu);
    }

    public List<Menu> convert(String value) {
        if (value.trim().isEmpty()) {
            return List.of();
        }
        return Arrays.stream(value.split(SEPARATOR))
                .map(Menu::from)
                .collect(Collectors.toList());
    }

    public void validateCannotEatMenu(String value) {
        if (value.trim().isEmpty()) {
            return;
        }
        if (value.startsWith(SEPARATOR)) {
            throw new IllegalArgumentException();
        }
        if (value.endsWith(SEPARATOR)) {
            throw new IllegalArgumentException();
        }
        if (value.contains(SEPARATOR.repeat(2))) {
            throw new IllegalArgumentException();
        }
        if (value.split(SEPARATOR).length > 2) {
            throw new IllegalArgumentException();
        }
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

    public String getName() {
        return name;
    }

    public List<Menu> getRecommendMenu() {
        return recommendMenu;
    }
}
