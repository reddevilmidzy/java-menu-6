package menu.model;

public enum Category {

    JAPANESE(1),
    KOREAN(2),
    CHINESE(3),
    ASIAN(4),
    WESTERN(5);

    private final int value;

    Category(int value) {
        this.value = value;
    }

    public static Category fromValueOf(int number) {
        for (Category category : Category.values()) {
            if (category.value == number) {
                return category;
            }
        }
        throw new IllegalStateException();
    }
}
