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

    @Test
    @DisplayName("주문이 공백일 경우 예외를 던져야 한다.")
    void 주문_공백_예외_테스트() {
        assertThatThrownBy(() -> validator.validateOrders(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문이 하이픈이 없을 경우 예외를 던져야 한다.")
    void 주문_하이픈_없는_예외_테스트() {
        assertThatThrownBy(() -> validator.validateOrders("티본스테이크1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문이 숫자가 없는 경우 예외를 던져야 한다.")
    void 주문_개수가_없는_예외_테스트() {
        assertThatThrownBy(() -> validator.validateOrders("티본스테이크-한개"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문이 메뉴가 없는 경우 예외를 던져야 한다.")
    void 주문_메뉴_없는_예외_테스트() {
        assertThatThrownBy(() -> validator.validateOrders("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주문이 메뉴와 개수가 없는 경우 예외를 던져야 한다.")
    void 주문_하이픈만_있는_예외_테스트() {
        assertThatThrownBy(() -> validator.validateOrders("-"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
