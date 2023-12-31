package christmas.constants;

import java.util.Arrays;
import java.util.List;

public class DiscountConstants {
    public static final int CURRENT_YEAR = 2023;

    public static final int MINIMUM_AMOUNT_FOR_DISCOUNT = 10000;
    public static final int GIFT_EVENT_START = 120000;
    public static final int GIFT_PRICE = 25000;

    public static final int CHRISTMAS_DISCOUNT_START = 1000;
    public static final int CHRISTMAS_DISCOUNT_INCREMENT = 100;
    public static final int CHRISTMAS_DISCOUNT_END_DAY = 25;

    public static final int WEEKDAY_DESSERT_DISCOUNT = 2023;
    public static final int WEEKEND_MAIN_DISCOUNT = 2023;

    public static final String CATEGORY_MAIN = "MAIN";
    public static final String CATEGORY_DESSERT = "DESSERT";

    public static final List<Integer> SPECIAL_DISCOUNT_DAYS = Arrays.asList(3, 10, 17, 24, 25, 31);
    public static final int SPECIAL_DISCOUNT_AMOUNT = 1000;
}
