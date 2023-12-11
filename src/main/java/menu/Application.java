package menu;

import menu.controller.LunchMenuRecommendationsController;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        LunchMenuRecommendationsController controller = new LunchMenuRecommendationsController(outputView);
        controller.run();
    }
}
