package christmas.controller;

import christmas.model.Discount;
import christmas.model.Order;
import christmas.service.CalculateService;
import christmas.service.DiscountService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class EventPlannerController {
    InputView inputView = new InputView();
    CalculateService calculateService = new CalculateService();
    DiscountService discountService = new DiscountService();
    OutputView outputView = new OutputView();

    public void startEventPlanner() {
        int visitDate = inputView.readDate();
        List<Order> orders = inputView.readOrder();

        int totalAmount = calculateService.calculateTotalAmount(orders);
        Discount discount = discountService.calculateTotalDiscount(visitDate, orders, totalAmount);

        outputView.printChristmasPlanner(visitDate, orders, totalAmount, discount);
    }
}
