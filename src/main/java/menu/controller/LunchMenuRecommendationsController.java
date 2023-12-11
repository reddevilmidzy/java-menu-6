package menu.controller;

import menu.view.OutputView;

public class LunchMenuRecommendationsController {

    private final OutputView outputView;

    public LunchMenuRecommendationsController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
    }
}
