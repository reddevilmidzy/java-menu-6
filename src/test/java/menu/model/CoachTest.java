package menu.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"최", "동글동글동글"})
    @DisplayName("코치 이름이 2이상 4이하가 아닐 시 예외")
    void createInvalidName(String value) {
        assertThatThrownBy(() -> Coach.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}