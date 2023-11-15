package christmas.view;

import christmas.model.Discount;
import christmas.model.Order;

import java.text.NumberFormat;
import java.util.List;

import static christmas.constants.DiscountConstants.GIFT_EVENT_START;

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
        String badge = "없음";
        int totalBenefits = discount.getTotalBenefits();

        if (totalBenefits >= 20000) {
            badge = "산타";
        } else if (totalBenefits >= 10000) {
            badge = "트리";
        } else if (totalBenefits >= 5000) {
            badge = "별";
        }

        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }

    private void printTotalAmountAfterDiscount(int totalAmount, Discount discount) {
        int totalAmountAfterDiscount = totalAmount - discount.getTotalDiscount();
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(numberFormat.format(totalAmountAfterDiscount) + "원");
    }

    private void printTotalBenefits(Discount discount) {
        int totalBenefits = discount.getTotalBenefits();
        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.println(numberFormat.format(-totalBenefits) + "원");

    }

    private void printBenefits(Discount discount) {
        boolean hasBenefits = false;
        System.out.println();
        System.out.println("<혜택 내역>");

        if (printChristmasDiscount(discount)) hasBenefits = true;
        if (printWeekdayDiscount(discount)) hasBenefits = true;
        if (printWeekendDiscount(discount)) hasBenefits = true;
        if (printSpecialDiscount(discount)) hasBenefits = true;
        if (printGiftMenuDiscount(discount)) hasBenefits = true;

        if (!hasBenefits) {
            System.out.println("없음");
        }
    }

    private boolean printGiftMenuDiscount(Discount discount) {
        int giftMenuDiscount = discount.getGiftMenuDiscount();
        if (giftMenuDiscount > 0) {
            System.out.println("증정 이벤트: -" + numberFormat.format(giftMenuDiscount) + "원");
            return true;
        }
        return false;
    }

    private boolean printSpecialDiscount(Discount discount) {
        int specialDiscount = discount.getSpecialDiscount();
        if (specialDiscount > 0) {
            System.out.println("특별 할인: -" + numberFormat.format(specialDiscount) + "원");
            return true;
        }
        return false;
    }

    private boolean printWeekendDiscount(Discount discount) {
        int weekendDiscount = discount.getWeekendDiscount();
        if (weekendDiscount > 0) {
            System.out.println("주말 할인: -" + numberFormat.format(weekendDiscount) + "원");
            return true;
        }
        return false;
    }

    private boolean printWeekdayDiscount(Discount discount) {
        int weekdayDiscount = discount.getWeekdayDiscount();
        if (weekdayDiscount > 0) {
            System.out.println("평일 할인: -" + numberFormat.format(weekdayDiscount) + "원");
            return true;
        }
        return false;
    }

    private boolean printChristmasDiscount(Discount discount) {
        int christmasDiscount = discount.getChristmasDiscount();
        if (christmasDiscount > 0) {
            System.out.println("크리스마스 디데이 할인: -" + numberFormat.format(christmasDiscount) + "원");
            return true;
        }
        return false;
    }

    private void printGiftMenu(int totalAmount) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        if (totalAmount >= GIFT_EVENT_START) {
            System.out.println("샴페인 1개");
        } else if (totalAmount < GIFT_EVENT_START) {
            System.out.println("없음");
        }

    }

    private void printTotalAmountBeforeDiscount(int totalAmount) {
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(numberFormat.format(totalAmount) + "원");
    }

    private void printOrder(List<Order> orders) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        for (Order order : orders) {
            System.out.println(order.getMenuName() + " " + order.getQuantity() + "개");
        }
    }

    private void printToday(int visitDate) {
        System.out.println("12월 " + visitDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }
}
