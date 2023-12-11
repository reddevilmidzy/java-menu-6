package menu.model;

public enum Menu {
    GYUDON(Category.JAPANESE, "규동"),
    UDON(Category.JAPANESE, "우동"),
    MISO_SOUP(Category.JAPANESE, "미소시루"),
    SUSHI(Category.JAPANESE, "스시"),
    KATSUDON(Category.JAPANESE, "가츠동"),
    ONIGIRI(Category.JAPANESE, "오니기리"),
    HIGH_RICE(Category.JAPANESE, "하이라이스"),
    RAMEN(Category.JAPANESE, "라멘"),
    OKONOMIYAKI(Category.JAPANESE, "오코노미야끼"),


    KIMBAP(Category.KOREAN, "김밥"),
    KIMCHI_STEW(Category.KOREAN, "김치찌개"),
    SSAMBAP(Category.KOREAN, "쌈밥"),
    SOYBEAN_PASTE_STEW(Category.KOREAN, "된장찌개"),
    BIBIMBAP(Category.KOREAN, "비빔밥"),
    KALGUKSU(Category.KOREAN, "칼국수"),
    BULGOGI(Category.KOREAN, "불고기"),
    TTEOKBOKKI(Category.KOREAN, "떡볶이"),
    STIR_FRIED_PORK(Category.KOREAN, "제육볶음"),

    KKANPUNGGI(Category.CHINESE, "깐풍기"),
    FRIED_NOODLES(Category.CHINESE, "볶음면"),
    DONGPO_PORK(Category.CHINESE, "동파육"),
    BLACK_BEAN_NOODLES(Category.CHINESE, "짜장면"),
    JJAMPPONG(Category.CHINESE, "짬뽕"),
    MAPO_TOFU(Category.CHINESE, "마파두부"),
    SWEET_AND_SOUR_PORK(Category.CHINESE, "탕수육"),
    STIR_FRIED_TOMATO_EGG(Category.CHINESE, "토마토 달걀볶음"),
    RED_PEPPER_JAPCHAE(Category.CHINESE, "고추잡채"),


    PAD_THAI(Category.ASIAN, "팟타이"),
    KHAO_PAD(Category.ASIAN, "카오 팟"),
    NASI_GORENG(Category.ASIAN, "나시고렝"),
    PINEAPPLE_FRIED_RICE(Category.ASIAN, "파인애플 볶음밥"),
    RICE_NOODLES(Category.ASIAN, "쌀국수"),
    TOM_YUM_GOONG(Category.ASIAN, "똠얌꿍"),
    BANH_MI(Category.ASIAN, "반미"),
    VIETNAMESE_SSAM(Category.ASIAN, "월남쌈"),
    BUN_CHA(Category.ASIAN, "분짜"),

    LASAGNA(Category.WESTERN, "라자냐"),
    GRATIN(Category.WESTERN, "그라탱"),
    GNOCCHI(Category.WESTERN, "뇨끼"),
    QUICHE(Category.WESTERN, "끼슈"),
    FRENCH_TOAST(Category.WESTERN, "프렌치 토스트"),
    BAGUETTE(Category.WESTERN, "바게트"),
    SPAGHETTI(Category.WESTERN, "스파게티"),
    PIZZA(Category.WESTERN, "피자"),
    PANINI(Category.WESTERN, "파니니"),

    ;


    private final Category category;
    private final String name;

    Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public static Menu nameOf(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        //TODO: 예외 메시지
        throw new IllegalArgumentException();
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}
