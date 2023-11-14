package christmas.controller;

import christmas.model.Order;
import christmas.service.CalculateService;
import christmas.service.DiscountService;
import christmas.view.InputView;

import java.util.List;

public class EventPlannerController {
    InputView inputView = new InputView();
    CalculateService calculateService = new CalculateService();
    DiscountService discountService = new DiscountService();

    public void startEventPlanner() {
        int visitDate = inputView.readDate();
        List<Order> orders  = inputView.readOrder();
        int totalAmount = calculateService.calculateTotalAmount(orders);
        int totalDiscount = discountService.calculateTotalDiscount(visitDate, orders);

    }
}
