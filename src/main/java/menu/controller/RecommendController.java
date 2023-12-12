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

        for (Category recommendCategory : categories) {
            coaches.initIterator();
            while (coaches.hasNext()) {
                Coach coach = coaches.next();
                recommendMenu(recommendation, recommendCategory, coach);
            }
        }

        outputView.printRecommendCategory(categories);
        coaches.initIterator();

        while (coaches.hasNext()) {
            Coach coach = coaches.next();
            outputView.printRecommendResult(coach);
        }

        outputView.printEndMessage();
    }

    private void recommendMenu(Recommendation recommendation, Category recommendCategory, Coach coach) {
        while (true) {
            Menu recommendMenu = recommendation.getRecommendMenu(recommendCategory);
            if (canRecommend(coach, recommendMenu)) {
                coach.addRecommendMenu(recommendMenu);
                break;
            }
        }
    }

    private boolean canRecommend(Coach coach, Menu recommendMenu) {
        return coach.canEat(recommendMenu) && !coach.duplicateMenu(recommendMenu);
    }
}
