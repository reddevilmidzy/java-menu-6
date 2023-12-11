package menu.service;

import menu.model.Category;
import menu.model.RecommendCategory;

public class CategoryRecommendation {

    public RecommendCategory recommend() {
        RecommendCategory recommend = new RecommendCategory();
        CategoryGenerator generator = new CategoryGenerator();

        while (!recommend.isDone()) {
            Category category = generator.generate();
            if (recommend.canRecommend(category)) {
                recommend.add(category);
            }
        }
        return recommend;
    }
}
