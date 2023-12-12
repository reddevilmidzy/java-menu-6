package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public Menu getRecommendMenu(Category category) {
        List<String> candidateMenus = Category.getMenusOf(category);
        return recommendMenu(candidateMenus);
    }

    private Category recommendCategory() {
        int index = generator.generate();
        return Category.indexOf(index);
    }

    private Menu recommendMenu(List<String> candidateMenus) {
        String name = Randoms.shuffle(candidateMenus).get(0);
        return Menu.from(name);
    }
}
