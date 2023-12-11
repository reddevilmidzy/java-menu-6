package menu.service;

import static org.assertj.core.api.Assertions.assertThat;

import menu.model.RecommendCategory;
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