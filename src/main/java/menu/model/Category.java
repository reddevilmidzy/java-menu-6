package menu.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5),
    ;

    private static Map<Category, List<String>> menusName = createMenus();

    private static Map<Category, List<String>> createMenus() {
        Map<Category, List<String>> result = new LinkedHashMap<>();

        for (Menu menu : Menu.values()) {
            List<String> categoryMenu = result.getOrDefault(menu.getCategory(), List.of());
            categoryMenu.add(menu.getName());
            result.put(menu.getCategory(), categoryMenu);
        }
        return result;
    }

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

    public static List<String> getMenusOf(Category category) {
        return menusName.get(category);
    }

    public String getName() {
        return name;
    }
}
