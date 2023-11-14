package christmas.model;

public class Discount {
    private final int christmasDiscount;
    private final int weekdayDiscount;
    private final int weekendDiscount;
    private final int specialDiscount;
    private final int giftMenuDiscount;

    public Discount(int christmasDiscount, int weekdayDiscount, int weekendDiscount,
                    int specialDiscount, int giftMenuDiscount) {
        this.christmasDiscount = christmasDiscount;
        this.weekdayDiscount = weekdayDiscount;
        this.weekendDiscount = weekendDiscount;
        this.specialDiscount = specialDiscount;
        this.giftMenuDiscount = giftMenuDiscount;
    }

    public int getChristmasDiscount() {
        return christmasDiscount;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public int getGiftMenuDiscount() {
        return giftMenuDiscount;
    }

    public int getTotalBenefits() {
        return christmasDiscount + weekdayDiscount + weekendDiscount + specialDiscount + giftMenuDiscount;
    }

    public int getTotalDiscount() {
        return christmasDiscount + weekdayDiscount + weekendDiscount + specialDiscount;
    }
}
