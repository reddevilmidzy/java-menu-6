package menu.model;

import java.util.ArrayList;
import java.util.List;

public enum Category {

    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식"),
    ;

    private final int value;
    private final String name;

    Category(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static Category fromValueOf(int number) {
        for (Category category : values()) {
            if (category.value == number) {
                return category;
            }
        }
        throw new IllegalStateException();
    }

    public static List<String> collectMenus(Category category) {
        List<String> result = new ArrayList<>();
        for (Menu menu : Menu.values()) {
            if (category.equals(menu.getCategory())) {
                result.add(menu.getName());
            }
        }
        return result;
    }

    public String getName() {
        return name;
    }
}
