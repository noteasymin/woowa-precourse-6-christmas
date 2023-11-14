package christmas.service;

import christmas.enums.Menu;
import christmas.model.Order;

import java.util.List;

public class CalculateService {
    public int calculateTotalAmount(List<Order> orders) {
        int totalAmount = 0;
        for (Order order : orders) {
            Menu menu = Menu.getMenuFromKoreanName(order.getMenuName());
            totalAmount += menu.getPrice() * order.getQuantity();
        }
        return totalAmount;
    }
}
