package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.ErrorMessages;
import christmas.util.PromptMessages;

public class InputView {
    public int readDate() {
        while (true) {
            System.out.println(PromptMessages.DATE_PROMPT);
            String input = Console.readLine();

            try {
                validateDateInput(input);
                return convertStringToInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateDateInput(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER);
        }

        int date = Integer.parseInt(input);
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DATE_RANGE);
        }
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
