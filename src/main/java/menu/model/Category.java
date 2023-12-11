package menu.model;

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
        for (Category category : Category.values()) {
            if (category.value == number) {
                return category;
            }
        }
        throw new IllegalStateException();
    }

    public String getName() {
        return name;
    }
}
