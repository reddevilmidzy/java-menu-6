package menu.controller;

import menu.model.Coaches;
import menu.view.OutputView;

public class RecommendController {

    private final InputController inputController;
    private final OutputView outputView;

    public RecommendController(InputController inputController, OutputView outputView) {
        this.inputController = inputController;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        Coaches coaches = inputController.getCoaches();
    }
}
