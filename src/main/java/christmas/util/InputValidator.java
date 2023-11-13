package christmas.util;

import christmas.enums.Menu;
import christmas.exception.ErrorMessages;

import java.util.HashMap;
import java.util.Map;

public class InputValidator {
    public void validateDateInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER);
        }

        int date = Integer.parseInt(input);
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DATE_RANGE);
        }
    }

    public Map<String, Integer> validateOrders(String input) {
        String[] orders = splitOrderByCommas(input);
        return countOrder(orders);
    }

    private Map<String, Integer> countOrder(String[] orders) {
        Map<String, Integer> orderDetails = new HashMap<>();

        for (String order : orders) {
            validOrder(orderDetails, order);
        }
        return orderDetails;
    }

    private void validOrder(Map<String, Integer> orderDetails, String order) {
        String[] splitOrder = order.split("-");
        try {
            String name = getNameBySplit(splitOrder);
            int quantity = getQuantityBySplit(splitOrder);
            if (!isMenuValid(name)) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_MENU);
            }
            orderDetails.put(name, quantity);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_MENU);
        }
    }

    private boolean isMenuValid(String name) {
        return Menu.inMenuFromKorean(name);
    }


    private String getNameBySplit(String[] splitOrder) {
        return splitOrder[0];
    }

    private int getQuantityBySplit(String[] splitOrder) {
        try {
            return Integer.parseInt(splitOrder[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_MENU);
        }
    }

    private String[] splitOrderByCommas(String input) {
        return input.split(",");
    }
}
