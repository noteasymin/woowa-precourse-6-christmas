package christmas.controller;

import christmas.view.InputView;

public class EventPlannerController {
    InputView inputView = new InputView();

    public void startEventPlanner() {
        int visitDate = inputView.readDate();
    }
}
