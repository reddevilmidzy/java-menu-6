package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.model.Category;

public class CategoryGenerator implements Generator<Category> {

    @Override
    public Category generate() {
        int number = getRandomNumber();
        return Category.fromValueOf(number);
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 5);
    }
}
