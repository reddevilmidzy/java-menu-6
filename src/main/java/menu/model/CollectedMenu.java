package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CollectedMenu {

    private static CollectedMenu collectedMenu;
    private static Map<Category, List<String>> menus = new LinkedHashMap<>();

    private CollectedMenu() {
        init();
    }

    public static CollectedMenu getInstance() {
        if (collectedMenu == null) {
            collectedMenu = new CollectedMenu();
        }
        return collectedMenu;
    }

    private static void init() {
        menus.put(Category.JAPANESE, Category.collectMenus(Category.JAPANESE));
        menus.put(Category.KOREAN, Category.collectMenus(Category.KOREAN));
        menus.put(Category.CHINESE, Category.collectMenus(Category.CHINESE));
        menus.put(Category.ASIAN, Category.collectMenus(Category.ASIAN));
        menus.put(Category.WESTERN, Category.collectMenus(Category.WESTERN));
    }

    public Menu recommend(Category category) {
        List<String> collect = menus.get(category);
        String menuName = Randoms.shuffle(collect).get(0);
        return Menu.nameOf(menuName);
    }

    public List<String> getMenu(Category category) {
        return menus.get(category);
    }
}
