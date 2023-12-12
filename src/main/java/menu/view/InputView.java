package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.model.Coach;

public class InputView {

    public String readCoaches() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String value = readLine();
        System.out.println();
        return value;
    }

    public String readCannotEatMenu(Coach coach) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", coach.getName());
        String value = readLine();
        System.out.println();
        return value;
    }

    protected String readLine() {
        return Console.readLine();
    }
}
