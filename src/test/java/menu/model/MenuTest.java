package menu.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    @DisplayName("메뉴 순서 확인")
    void createMenus() {
        for (Menu menu : Menu.values()) {
            System.out.println(menu);
        }
    }
}