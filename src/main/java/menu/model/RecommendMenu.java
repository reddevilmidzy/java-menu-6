package menu.model;

import java.util.ArrayList;
import java.util.Iterator;
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

    public String join(String value) {
        StringBuilder builder = new StringBuilder();
        Iterator<Menu> iterator = menus.iterator();
        builder.append(iterator.next().getName());
        while (iterator.hasNext()) {
            builder.append(value);
            builder.append(iterator.next().getName());
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return menus.toString();
    }
}
