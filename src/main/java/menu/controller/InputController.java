package menu.controller;

import java.util.List;
import menu.model.Coach;
import menu.model.Coaches;
import menu.model.Menu;
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
                outputView.printErrorMessage(exception);
            }
        }
    }

    public List<Menu> getCannotEatMenu(Coach coach) {
        while (true) {
            try {
                return readCannotEatMenu(coach);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }

    private List<Menu> readCannotEatMenu(Coach coach) {
        String value = inputView.readCannotEatMenu(coach);
        coach.validateCannotEatMenu(value);
        return coach.convert(value);
    }

    private Coaches readCoaches() {
        String coaches = inputView.readCoaches();
        return Coaches.from(coaches);
    }
}
