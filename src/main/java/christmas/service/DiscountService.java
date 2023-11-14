package christmas.service;

import christmas.model.Order;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static christmas.constants.DiscountConstants.SPECIAL_DISCOUNT_AMOUNT;
import static christmas.constants.DiscountConstants.SPECIAL_DISCOUNT_DAYS;

public class DiscountService {
    public int calculateTotalDiscount(int visitDate, List<Order> orders) {
        int christmasDiscount = calculateChristmasDiscount(visitDate);
        int weekdayDiscount = calculateWeekdayDiscount(visitDate, orders);
        int weekendDiscount = calculateWeekendDiscount(visitDate, orders);
        int specialDiscount = calculateSpecialDiscount(visitDate);
        return 0;
    }

    private int calculateSpecialDiscount(int visitDate) {
        if (SPECIAL_DISCOUNT_DAYS.contains(visitDate)) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private int calculateWeekendDiscount(int visitDate, List<Order> orders) {
        int weekendDiscount = 0;
        if (isWeekend(visitDate)) {
            for (Order order : orders) {
                weekendDiscount += calculateWeekendMainDiscount(order);
            }
        }
        return weekendDiscount;
    }

    private int calculateWeekendMainDiscount(Order order) {
        if (order.getCategory().equals("MAIN")) {
            return 2023;
        }
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
