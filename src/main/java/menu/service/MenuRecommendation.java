package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Menu;
import menu.model.RecommendCategory;
import menu.model.RecommendMenu;

public class MenuRecommendation {

    public RecommendMenu createRecommend(Coach coach, RecommendCategory categories) {
        RecommendMenu result = new RecommendMenu();
        categories.initIterator();
        while (categories.hasNext()) {
            Category category = categories.next();
            List<Menu> candidateMenus = getMenus(category);
            //TODO: 메서드 분리
            recommend(coach, result, candidateMenus);
        }
        return result;
    }

    private void recommend(Coach coach, RecommendMenu result, List<Menu> candidate) {
        while (true) {
            Menu recommendMenu = recommend(candidate);
            if (canRecommend(coach, result, recommendMenu)) {
                result.add(recommendMenu);
                break;
            }
        }
    }

    private boolean canRecommend(Coach coach, RecommendMenu result, Menu recommendMenu) {
        return coach.canEat(recommendMenu) && !result.duplicate(recommendMenu);
    }

    private Menu recommend(List<Menu> menus) {
        return Randoms.shuffle(menus).get(0);
    }

    //TODO: 사실 카테고리 마다 계속 List 생성하는건 낭비같음 다른 방법 혹은 최적화 필요
    private List<Menu> getMenus(Category category) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.getCategory().equals(category))
                .collect(Collectors.toList());
    }
}
