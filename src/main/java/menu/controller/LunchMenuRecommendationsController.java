package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.Coach;
import menu.model.CoachName;
import menu.model.RecommendCategory;
import menu.model.RecommendMenu;
import menu.service.CategoryRecommendation;
import menu.service.MenuRecommendation;
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

        List<Coach> coaches = readCanNotEatMenus(coachNames);
        RecommendCategory category = recommendCategory();

        MenuRecommendation recommendation = new MenuRecommendation();
        List<RecommendMenu> recommendMenus = recommendMenu(coaches, category, recommendation);
        outputView.printResult();
    }

    private List<RecommendMenu> recommendMenu(List<Coach> coaches, RecommendCategory category,
                                              MenuRecommendation recommendation) {
        List<RecommendMenu> recommendMenus = new ArrayList<>();

        for (Coach coach : coaches) {
            recommendMenus.add(recommendation.createRecommend(coach, category));
        }
        return recommendMenus;
    }

    private RecommendCategory recommendCategory() {
        CategoryRecommendation categoryRecommendation = new CategoryRecommendation();
        return categoryRecommendation.recommend();
    }

    private List<Coach> readCanNotEatMenus(List<CoachName> coachNames) {
        List<Coach> coaches = new ArrayList<>();

        for (CoachName coachName : coachNames) {
            String menus = inputView.readMenuCannotEat(coachName);
            Coach coach = Coach.of(coachName, menus);
            coaches.add(coach);
        }
        return coaches;
    }
}
