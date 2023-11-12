package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.ErrorMessages;

public class InputView {
    public int readDate() {
        while (true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
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
