package menu.controller;

import menu.model.Coaches;
import menu.view.InputView;
import menu.view.OutputView;

public class InputController {

    private final InputView inputView;
    private final OutputView outputView;

    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Coaches getCoaches() {
        while (true) {
            try {
                return readCoaches();
            } catch (IllegalArgumentException exception) {
                //TODO: 예외 출력
            }
        }
    }

    private Coaches readCoaches() {
        String coaches = inputView.readCoaches();
        return Coaches.from(coaches);
    }
}
