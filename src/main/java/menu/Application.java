package menu;

import menu.controller.InputController;
import menu.controller.RecommendController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputController inputController = new InputController(inputView, outputView);
        RecommendController controller = new RecommendController(inputController, outputView);
        controller.run();
    }
}
