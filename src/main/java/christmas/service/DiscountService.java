package christmas.service;

import christmas.model.Order;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class DiscountService {
    public int calculateTotalDiscount(int visitDate, List<Order> orders) {
        int christmasDiscount = calculateChristmasDiscount(visitDate);
        int weekdayDiscount = calculateWeekdayDiscount(visitDate, orders);
        return 0;
    }

    private int calculateWeekdayDiscount(int visitDate, List<Order> orders) {
        int weekdayDiscount = 0;
        if (isWeekday(visitDate)) {
            for (Order order : orders) {
                weekdayDiscount += calculateWeekdayDessertDiscount(order);
            }
        }
        return weekdayDiscount;
    }

    private int calculateWeekdayDessertDiscount(Order order) {
        if (order.getCategory().equals("DESSERT")) {
            return 2023;
        }
        return 0;
    }

    private int calculateChristmasDiscount(int visitDate) {
        if (visitDate <= 25) {
            int christmasDiscount = 1000;
            christmasDiscount += visitDate * 100 - 100;
            return christmasDiscount;
        }
        return 0;
    }

    public boolean isWeekend(int dayOfMonth) {
        LocalDate date = LocalDate.of(2023, Month.DECEMBER, dayOfMonth);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    public boolean isWeekday(int dayOfMonth) {
        return !isWeekend(dayOfMonth);
    }
}
