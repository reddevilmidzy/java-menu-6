package menu.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5),
    ;

    private final String name;
    private final int index;

    Category(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static Category indexOf(int index) {
        for (Category category : Category.values()) {
            if (category.index == index) {
                return category;
            }
        }
        throw new IllegalArgumentException();
    }

    public List<String> getMenus() {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getCategory().equals(this))
                .map(Menu::getName)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
