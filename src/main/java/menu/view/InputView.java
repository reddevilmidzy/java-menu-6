package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.model.CoachName;

public class InputView {

    public String readNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String names = readLine();
        System.out.println();
        return names;
    }

    public String readMenuCannotEat(CoachName name) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", name.getName());
        String menus = readLine();
        System.out.println();
        return menus;
    }

    protected String readLine() {
        return Console.readLine();
    }
}
