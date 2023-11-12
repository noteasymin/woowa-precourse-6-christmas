package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.InputValidator;
import christmas.util.PromptMessages;

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
}
