package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.Category;
import menu.model.Menu;

public class Recommendation {

    private final Generator<Integer> generator;

    public Recommendation(Generator<Integer> generator) {
        this.generator = generator;
    }

    public List<Category> getRecommendCategory() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < 5) {
            Category category = recommendCategory();
            if (Collections.frequency(categories, category) <= 1) {
                categories.add(category);
            }
        }
        return categories;
    }

    private Category recommendCategory() {
        int index = generator.generate();
        return Category.indexOf(index);
    }

    public Menu recommendMenu(List<Menu> menus) {
        List<String> candidateMenus = menus.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
        String name = Randoms.shuffle(candidateMenus).get(0);
        return Menu.from(name);
    }
}
