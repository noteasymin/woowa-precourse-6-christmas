package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Order;
import christmas.util.InputValidator;
import christmas.util.PromptMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InputView {
    InputValidator inputValidator = new InputValidator();

    public int readDate() {
        while (true) {
            System.out.println(PromptMessages.DATE_PROMPT);
            String input = Console.readLine();

            try {
                inputValidator.validateDateInput(input);
                return convertStringToInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public List<Order> readOrder() {
        while (true) {
            System.out.println(PromptMessages.ORDER_PROMPT);
            String input = Console.readLine();

            try {
                Map<String, Integer> validatedOrders = inputValidator.validateOrders(input);
                return putOrdersToOrder(validatedOrders);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Order> putOrdersToOrder(Map<String, Integer> validatedOrders) {
        List<Order> orders = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : validatedOrders.entrySet()) {
            Order order = new Order(entry.getKey(), entry.getValue());
            orders.add(order);
        }
        return orders;
    }
}
