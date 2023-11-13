package christmas.controller;

import christmas.model.Order;
import christmas.view.InputView;

import java.util.List;

public class EventPlannerController {
    InputView inputView = new InputView();

    public void startEventPlanner() {
        int visitDate = inputView.readDate();
        List<Order> orders  = inputView.readOrder();


    }
}
