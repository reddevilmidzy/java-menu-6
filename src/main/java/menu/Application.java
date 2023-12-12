package menu;

import menu.controller.RecommendController;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        RecommendController controller = new RecommendController(outputView);
        controller.run();
    }
}
