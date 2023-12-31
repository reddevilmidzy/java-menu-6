package menu.view;

import java.util.List;
import java.util.stream.Collectors;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Menu;

public class OutputView {

    public static final String ERROR_PREFIX = "[ERROR] %s%n";

    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }

    public void printRecommendCategory(List<Category> recommend) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.print("[ 카테고리 | ");
        String joiningSeparator = recommend.stream()
                .map(Category::getName)
                .collect(Collectors.joining(" | "));
        System.out.print(joiningSeparator);
        System.out.println(" ]");
    }

    public void printRecommendResult(Coach coach) {
        System.out.printf("[ %s | ", coach.getName());
        String joiningSeparator = coach.getRecommendMenu().stream()
                .map(Menu::getName)
                .collect(Collectors.joining(" | "));
        System.out.print(joiningSeparator);
        System.out.println(" ]");
    }

    public void printEndMessage() {
        System.out.println();
        System.out.print("추천을 완료했습니다.");
    }

    public void printErrorMessage(Throwable error) {
        System.out.printf(ERROR_PREFIX, error.getMessage());
    }
}
