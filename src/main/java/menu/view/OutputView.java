package menu.view;

import menu.model.RecommendCategory;

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
}
