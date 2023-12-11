package menu.model;

import java.util.ArrayList;
import java.util.List;

public class RecommendMenu {

    private List<Menu> menus;

    public RecommendMenu() {
        this.menus = new ArrayList<>();
    }

    public boolean duplicate(Menu menu) {
        return contains(menu);
    }

    private boolean contains(Menu menu) {
        return menus.contains(menu);
    }

    public void add(Menu menu) {
        menus.add(menu);
    }

    @Override
    public String toString() {
        return menus.toString();
    }
}
