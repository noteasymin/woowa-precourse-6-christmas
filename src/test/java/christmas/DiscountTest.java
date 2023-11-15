package christmas;

import christmas.model.Discount;
import christmas.model.Order;
import christmas.service.CalculateService;
import christmas.service.DiscountService;
import christmas.util.InputValidator;
import christmas.view.InputView;
import christmas.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DiscountTest {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputValidator inputValidator = new InputValidator();
    DiscountService discountService = new DiscountService();
    CalculateService calculateService = new CalculateService();

    @Test
    @DisplayName("1일 일 경우 크리스마스 디데이 할인으로 1000원 할인되야 한다.")
    void 크리스마스_디데이_할인_1일_테스트() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("티본스테이크", 1, "MAIN");
        orders.add(order);
        Discount discount = discountService.calculateTotalDiscount(1, orders, calculateService.calculateTotalAmount(orders));
        Assertions.assertThat(discount.getChristmasDiscount()).isEqualTo(1000);
    }

    @Test
    @DisplayName("25일 일 경우 크리스마스 디데이 할인으로 3400원 할인되야 한다.")
    void 크리스마스_디데이_할인_31일_테스트() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("티본스테이크", 1, "MAIN");
        orders.add(order);
        Discount discount = discountService.calculateTotalDiscount(25, orders, calculateService.calculateTotalAmount(orders));
        Assertions.assertThat(discount.getChristmasDiscount()).isEqualTo(3400);
    }

    @Test
    @DisplayName("25일 이후일 경우 크리스마스 디데이 할인이 없어야 한다.")
    void 크리스마스_디데이_할인_26일_테스트() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("티본스테이크", 1, "MAIN");
        orders.add(order);
        Discount discount = discountService.calculateTotalDiscount(26, orders, calculateService.calculateTotalAmount(orders));
        Assertions.assertThat(discount.getChristmasDiscount()).isEqualTo(0);
    }

    @Test
    @DisplayName("평일일 경우 디저트 개수 * 2023 만큼 할인되어야 한다.")
    void 평일_디저트_할인_테스트() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("초코케이크", 1, "DESSERT");
        orders.add(order);
        Discount discount = discountService.calculateTotalDiscount(4, orders, calculateService.calculateTotalAmount(orders));
        Assertions.assertThat(discount.getWeekdayDiscount()).isEqualTo(2023);
    }

    @Test
    @DisplayName("평일일 경우 메인 메뉴이면 할인이 없어야 한다.")
    void 평일_메인_할인_테스트() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("티본스테이크", 1, "MAIN");
        orders.add(order);
        Discount discount = discountService.calculateTotalDiscount(4, orders, calculateService.calculateTotalAmount(orders));
        Assertions.assertThat(discount.getWeekdayDiscount()).isEqualTo(0);
    }

    @Test
    @DisplayName("주말일 경우 메인 개수 * 2023 만큼 할인되어야 한다.")
    void 주말_메인_할인_테스트() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("티본스테이크", 1, "MAIN");
        orders.add(order);
        Discount discount = discountService.calculateTotalDiscount(2, orders, calculateService.calculateTotalAmount(orders));
        Assertions.assertThat(discount.getWeekendDiscount()).isEqualTo(2023);
    }

    @Test
    @DisplayName("주말일 경우 메인 제외는 할인이 없어야 한다.")
    void 주말_디저트_할인_테스트() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("초코케이크", 1, "DESSERT");
        orders.add(order);
        Discount discount = discountService.calculateTotalDiscount(4, orders, calculateService.calculateTotalAmount(orders));
        Assertions.assertThat(discount.getWeekendDiscount()).isEqualTo(0);
    }

    @Test
    @DisplayName("일요일과 25일은 특별 할인이 적용된다.")
    void 특별_할인_적용() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("초코케이크", 1, "DESSERT");
        orders.add(order);
        Discount discount = discountService.calculateTotalDiscount(25, orders, calculateService.calculateTotalAmount(orders));
        Assertions.assertThat(discount.getSpecialDiscount()).isEqualTo(1000);
    }

    @Test
    @DisplayName("일요일과 25일 외에는 특별 할인이 적용되지 않는다.")
    void 특별_할인_미적용() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("초코케이크", 1, "DESSERT");
        orders.add(order);
        Discount discount = discountService.calculateTotalDiscount(4, orders, calculateService.calculateTotalAmount(orders));
        Assertions.assertThat(discount.getWeekendDiscount()).isEqualTo(0);
    }

    @Test
    @DisplayName("주문 금액이 12만원 이상일 경우 샴페인을 증정해야 한다.")
    void 주문_금액_12만원_증정_테스트() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("티본스테이크", 4, "MAIN");
        orders.add(order);
        Discount discount = discountService.calculateTotalDiscount(1, orders, calculateService.calculateTotalAmount(orders));
        Assertions.assertThat(discount.getGiftMenuDiscount()).isEqualTo(25000);
    }

    @Test
    @DisplayName("주문 금액이 12만원 미만일 경우 샴페인을 증정해야 한다.")
    void 주문_금액_12만원_미만_증정_테스트() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("티본스테이크", 2, "MAIN");
        orders.add(order);
        Discount discount = discountService.calculateTotalDiscount(1, orders, calculateService.calculateTotalAmount(orders));
        Assertions.assertThat(discount.getGiftMenuDiscount()).isEqualTo(0);
    }
}
