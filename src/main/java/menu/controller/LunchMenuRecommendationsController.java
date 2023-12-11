package menu.controller;

import menu.model.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class LunchMenuRecommendationsController {

    private final InputView inputView;
    private final OutputView outputView;

    public LunchMenuRecommendationsController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        String names = inputView.readNames();
        Coaches coaches = Coaches.from(names);


    }
}
