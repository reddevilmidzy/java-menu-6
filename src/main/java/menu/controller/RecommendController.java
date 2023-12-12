package menu.controller;

import java.util.List;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Coaches;
import menu.model.Menu;
import menu.service.Generator;
import menu.service.RandomNumberGenerator;
import menu.service.Recommendation;
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

        coaches.initIterator();

        while (coaches.hasNext()) {
            Coach coach = coaches.next();
            List<Menu> cannotEatMenu = inputController.getCannotEatMenu(coach);
            coach.setCannotEatMenu(cannotEatMenu);
        }

        Generator<Integer> generator = new RandomNumberGenerator();
        Recommendation recommendation = new Recommendation(generator);
        List<Category> categories = recommendation.getRecommendCategory();
        System.out.println(categories);
    }
}
