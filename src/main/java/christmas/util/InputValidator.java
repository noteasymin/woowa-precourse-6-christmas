package christmas.util;

import christmas.enums.Menu;

import java.util.HashMap;
import java.util.Map;

import static christmas.exception.ErrorMessages.*;

public class InputValidator {
    public void validateDateInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }

        int date = Integer.parseInt(input);
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(INVALID_DATE_RANGE);
        }
    }

    private void validateOrderQuantity(Map<String, Integer> orderDetails) {
        int totalQuantity = orderDetails.values().stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (totalQuantity > 20) {
            throw new IllegalArgumentException(INVALID_ORDER_QUANTITY);
        }
    }

    private void validateDrinkOnlyOrder(Map<String, Integer> orderDetails) {
        boolean isDrinkOnly = orderDetails.keySet().stream()
                .allMatch(name -> Menu.getMenuFromKoreanName(name).getCategory() == Menu.Category.DRINK);

        if (isDrinkOnly) {
            throw new IllegalArgumentException(DRINK_ONLY_ORDER_NOT_ALLOWED);
        }
    }

    public Map<String, Integer> validateOrders(String input) {
        String[] orders = splitOrderByCommas(input);
        Map<String, Integer> orderDetails = countOrder(orders);

        validateOrderQuantity(orderDetails);
        validateDrinkOnlyOrder(orderDetails);

        return orderDetails;
    }

    private Map<String, Integer> countOrder(String[] orders) {
        Map<String, Integer> orderDetails = new HashMap<>();

        for (String order : orders) {
            validateOrderInput(orderDetails, order);
        }
        return orderDetails;
    }

    private void validateOrderInput(Map<String, Integer> orderDetails, String order) {
        String[] splitOrder = order.split("-");
        try {
            String name = getNameBySplit(splitOrder);
            int quantity = getQuantityBySplit(splitOrder);

            if (!isMenuValid(name)) {
                throw new IllegalArgumentException(INVALID_MENU);
            }
            if (validateDuplicateOrder(orderDetails, name)) {
                throw new IllegalArgumentException(DUPLICATE_MENU);
            }
            orderDetails.put(name, quantity);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_MENU);
        }
    }

    private boolean validateDuplicateOrder(Map<String, Integer> orderDetails, String name) {
        return orderDetails.containsKey(name);
    }

    private boolean isMenuValid(String name) {
        return Menu.inMenuFromKorean(name);
    }


    private String getNameBySplit(String[] splitOrder) {
        try {
            return splitOrder[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(INVALID_MENU);
        }
    }

    private int getQuantityBySplit(String[] splitOrder) {
        try {
            return Integer.parseInt(splitOrder[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(INVALID_MENU);
        }
    }

    private String[] splitOrderByCommas(String input) {
        return input.split(",");
    }
}
