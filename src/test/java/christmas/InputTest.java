package christmas;

import christmas.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputTest {
    InputValidator validator = new InputValidator();

    @Test
    @DisplayName("방문 일이 1 미만일 경우 예외를 던져야 한다.")
    void 날짜_1_미만_예외_테스트() {
        assertThatThrownBy(() -> validator.validateDateInput("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("방문 일이 1 미만일 경우 예외를 던져야 한다.")
    void 날짜_31_초과_예외_테스트() {
        assertThatThrownBy(() -> validator.validateDateInput("32"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("방문 일이 문자일 경우 예외를 던져야 한다.")
    void 날짜_문자_입력_예외_테스트() {
        assertThatThrownBy(() -> validator.validateDateInput("안녕"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("방문 일이 없을 경우 예외를 던져야 한다.")
    void 날짜_공백_예외_테스트() {
        assertThatThrownBy(() -> validator.validateDateInput(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
