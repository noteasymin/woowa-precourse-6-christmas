package christmas.view;

import christmas.enums.Badge;
import christmas.model.Discount;
import christmas.model.Order;

import java.text.NumberFormat;
import java.util.List;

import static christmas.constants.DiscountConstants.GIFT_EVENT_START;
import static christmas.constants.OutputConstants.*;
import static christmas.constants.TextConstants.*;

public class OutputView {
    NumberFormat numberFormat = NumberFormat.getNumberInstance();

    public void printChristmasPlanner(int visitDate, List<Order> orders, int totalAmount, Discount discount) {
        printToday(visitDate);
        printOrder(orders);
        printTotalAmountBeforeDiscount(totalAmount);
        printGiftMenu(totalAmount);
        printBenefits(discount);
        printTotalBenefits(discount);
        printTotalAmountAfterDiscount(totalAmount, discount);
        printEventBadge(discount);
    }

    private void printEventBadge(Discount discount) {
        int totalBenefits = discount.getTotalBenefits();
        Badge badge = Badge.fromTotalBenefits(totalBenefits);

        System.out.println();
        System.out.println(EVENT_BADGE_HEADER);
        System.out.println(badge);
    }

    private void printTotalAmountAfterDiscount(int totalAmount, Discount discount) {
        int totalAmountAfterDiscount = totalAmount - discount.getTotalDiscount();
        System.out.println();
        System.out.println(TOTAL_AMOUNT_AFTER_DISCOUNT_HEADER);
        System.out.println(numberFormat.format(totalAmountAfterDiscount) + WON);
    }

    private void printTotalBenefits(Discount discount) {
        int totalBenefits = discount.getTotalBenefits();
        System.out.println();
        System.out.println(TOTAL_BENEFITS_HEADER);
        System.out.println(numberFormat.format(-totalBenefits) + WON);

    }

    private void printBenefits(Discount discount) {
        boolean hasBenefits = false;
        System.out.println();
        System.out.println(BENEFITS_HEADER);

        if (printChristmasDiscount(discount)) hasBenefits = true;
        if (printWeekdayDiscount(discount)) hasBenefits = true;
        if (printWeekendDiscount(discount)) hasBenefits = true;
        if (printSpecialDiscount(discount)) hasBenefits = true;
        if (printGiftMenuDiscount(discount)) hasBenefits = true;

        if (!hasBenefits) {
            System.out.println(NOTHING);
        }
    }

    private boolean printGiftMenuDiscount(Discount discount) {
        int giftMenuDiscount = discount.getGiftMenuDiscount();
        if (giftMenuDiscount > 0) {
            System.out.println(GIFT_EVENT_LABEL + numberFormat.format(giftMenuDiscount) + WON);
            return true;
        }
        return false;
    }

    private boolean printSpecialDiscount(Discount discount) {
        int specialDiscount = discount.getSpecialDiscount();
        if (specialDiscount > 0) {
            System.out.println(SPECIAL_DISCOUNT_LABEL + numberFormat.format(specialDiscount) + WON);
            return true;
        }
        return false;
    }

    private boolean printWeekendDiscount(Discount discount) {
        int weekendDiscount = discount.getWeekendDiscount();
        if (weekendDiscount > 0) {
            System.out.println(WEEKEND_DISCOUNT_LABEL + numberFormat.format(weekendDiscount) + WON);
            return true;
        }
        return false;
    }

    private boolean printWeekdayDiscount(Discount discount) {
        int weekdayDiscount = discount.getWeekdayDiscount();
        if (weekdayDiscount > 0) {
            System.out.println(WEEKDAY_DISCOUNT_LABEL + numberFormat.format(weekdayDiscount) + WON);
            return true;
        }
        return false;
    }

    private boolean printChristmasDiscount(Discount discount) {
        int christmasDiscount = discount.getChristmasDiscount();
        if (christmasDiscount > 0) {
            System.out.println(CHRISTMAS_DISCOUNT_LABEL + numberFormat.format(christmasDiscount) + WON);
            return true;
        }
        return false;
    }

    private void printGiftMenu(int totalAmount) {
        System.out.println();
        System.out.println(GIFT_MENU_HEADER);
        if (totalAmount >= GIFT_EVENT_START) {
            System.out.println(CHAMPAGNE_LABEL);
        } else if (totalAmount < GIFT_EVENT_START) {
            System.out.println(NOTHING);
        }

    }

    private void printTotalAmountBeforeDiscount(int totalAmount) {
        System.out.println();
        System.out.println(TOTAL_AMOUNT_BEFORE_DISCOUNT_HEADER);
        System.out.println(numberFormat.format(totalAmount) + WON);
    }

    private void printOrder(List<Order> orders) {
        System.out.println();
        System.out.println(ORDER_HEADER);
        for (Order order : orders) {
            System.out.println(order.getMenuName() + " " + order.getQuantity() + COUNT);
        }
    }

    private void printToday(int visitDate) {
        System.out.printf((TODAY_EVENT_PREVIEW) + "%n", visitDate);
    }
}
