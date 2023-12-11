package menu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendCategory {

    private List<Category> categories;

    public RecommendCategory() {
        this.categories = new ArrayList<>();
    }

    public boolean canRecommend(Category target) {
        return Collections.frequency(categories, target) < 2;
    }

    public void add(Category category) {
        categories.add(category);
    }

    public boolean isDone() {
        return categories.size() == 5;
    }
}
