package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.Coach;
import menu.model.CoachName;
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

        //TODO: 코치 이터레이터로 구현
        List<CoachName> coachNames = Arrays.stream(names.split(","))
                .map(CoachName::new)
                .collect(Collectors.toList());

        List<Coach> coaches = new ArrayList<>();

        for (CoachName coachName : coachNames) {
            String menus = inputView.readMenuCannotEat(coachName);
            Coach coach = Coach.of(coachName, menus);
            coaches.add(coach);
        }

    }
}
