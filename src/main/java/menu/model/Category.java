package menu.model;

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


}
