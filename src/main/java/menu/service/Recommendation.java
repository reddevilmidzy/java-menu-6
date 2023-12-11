package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Menu;
import menu.model.RecommendMenu;

public class Recommendation {

    public Menu recommend(List<Menu> menus) {
        return Randoms.shuffle(menus).get(0);
    }

    public RecommendMenu createRecommend(Coach coach, List<Category> categories) {
        RecommendMenu result = new RecommendMenu();

        for (Category category : categories) {
            List<Menu> candidate = getMenus(category);
            //TODO: 메서드 분리
            while (true) {
                Menu recommendMenu = recommend(candidate);
                if (coach.canEat(recommendMenu) && result.canRecommend(recommendMenu)) {
                    result.add(recommendMenu);
                    break;
                }
            }
        }
        return result;
    }

    //TODO: 사실 카테고리 마다 계속 List 생성하는건 낭비같음 다른 방법 혹은 최적화 필요
    private List<Menu> getMenus(Category category) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getCategory().equals(category))
                .collect(Collectors.toList());
    }
}
