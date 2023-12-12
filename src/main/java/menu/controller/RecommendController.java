package menu.controller;

import menu.view.OutputView;

public class RecommendController {

    private final OutputView outputView;

    public RecommendController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
    }
}
