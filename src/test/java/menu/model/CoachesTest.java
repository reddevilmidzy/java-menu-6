package menu.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachesTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "토미", ",토미", "토미,,제임스,포코", "토미,제임스,", "토미,제임스,포코,동글,앙마,커피"})
    @DisplayName("잘못된 코치 입력시 예외 발생")
    void createInvalidCoachName(String value) {

        assertThatThrownBy(() -> Coaches.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"동근,동글,동근", "오른손,오른손"})
    @DisplayName("중복된 코치 이름 입력시 예외")
    void createDuplicate(String value) {

        assertThatThrownBy(() -> Coaches.from(value))
                .isInstanceOf(IllegalArgumentException.class);

    }
}