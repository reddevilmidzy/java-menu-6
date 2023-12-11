package menu.service;

import menu.model.Category;
import menu.model.Coach;
import menu.model.CollectedMenu;
import menu.model.Menu;

public class MenuRecommendation {

    public void recommend(Coach coach, Category category) {
        CollectedMenu collectedMenu = CollectedMenu.getInstance();
        Menu menu = collectedMenu.recommend(category);

        if (coach.canRecommend(menu)) {
            coach.add(menu);
            return;
        }
        //TODO: 재귀 없애기
        recommend(coach, category);

    }
}
