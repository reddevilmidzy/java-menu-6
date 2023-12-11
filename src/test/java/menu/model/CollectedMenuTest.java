package menu.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CollectedMenuTest {


    @Test
    @DisplayName("생성 확인")
    void createInit() {
        //given
        CollectedMenu collectedMenu = CollectedMenu.getInstance();

        //when
        Menu recommend = collectedMenu.recommend(Category.ASIAN);
        System.out.println(recommend);
        System.out.println(collectedMenu.getMenu(Category.ASIAN));

        recommend = collectedMenu.recommend(Category.ASIAN);
        System.out.println(recommend);
        System.out.println(collectedMenu.getMenu(Category.ASIAN));

        recommend = collectedMenu.recommend(Category.ASIAN);
        System.out.println(recommend);
        System.out.println(collectedMenu.getMenu(Category.ASIAN));

        //then

    }


    @Test
    @DisplayName("랜덤 정렬 ")
    void randomTest() {
        //given
        List<String> tmp = List.of("1", "2", "3", "4");

        //when
        List<String> shuffle = Randoms.shuffle(tmp);

        //then
        System.out.println(shuffle);
        System.out.println(tmp);
    }
}