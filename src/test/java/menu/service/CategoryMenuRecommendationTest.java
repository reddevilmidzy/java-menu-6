package menu.service;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import menu.model.Category;
import menu.model.RecommendCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryMenuRecommendationTest {


    @Test
    @DisplayName("5일의 카테고리 추천")
    void createRecommendCategory() {
        //given
        CategoryRecommendation recommendation = new CategoryRecommendation();

        //when
        RecommendCategory recommend = recommendation.recommend();

        //then
        assertThat(recommend.isDone()).isTrue();
    }
}