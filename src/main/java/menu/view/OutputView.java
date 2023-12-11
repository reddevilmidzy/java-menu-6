package menu.view;

import java.util.Map;
import menu.model.Coach;
import menu.model.RecommendCategory;
import menu.model.RecommendMenu;

public class OutputView {

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public void printResult() {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }


    public void printRecommendCategory(RecommendCategory category) {
        System.out.print("[ 카테고리 | ");
        String joinedCategory = category.join(" | ");
        System.out.print(joinedCategory);
        System.out.println(" ]");
    }

    public void printRecommendMenu(Map<Coach, RecommendMenu> recommendMenu) {
        for (Coach coach : recommendMenu.keySet()) {
            System.out.printf("[ %s | ", coach.getName());
            RecommendMenu menus = recommendMenu.get(coach);
            String joinedMenu = menus.join(" | ");
            System.out.print(joinedMenu);
            System.out.println(" ]");
        }
        System.out.println();
    }

    public void printEndMessage() {
        System.out.println("추천을 완료했습니다.");
    }
}
