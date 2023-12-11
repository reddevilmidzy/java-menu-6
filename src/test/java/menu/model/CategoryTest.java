package menu.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CategoryTest {


    @ParameterizedTest
    @MethodSource("parametersProvider")
    @DisplayName("올바른 메뉴 반환")
    void createMenu(int number, Category expected) {
        //given, when
        Category category = Category.fromValueOf(number);

        //then
        assertThat(category).isEqualTo(expected);
    }


    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                Arguments.of(1, Category.JAPANESE),
                Arguments.of(2, Category.KOREAN),
                Arguments.of(3, Category.CHINESE),
                Arguments.of(4, Category.ASIAN),
                Arguments.of(5, Category.WESTERN)
        );
    }
}