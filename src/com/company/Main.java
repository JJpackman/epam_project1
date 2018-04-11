package com.company;

import com.company.controller.FlowerController;
import com.company.controller.command.FlowerCommandInvoker;
import com.company.model.FlowerShop;
import com.company.view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        FlowerShop model = new FlowerShop();
        ConsoleView view = new ConsoleView();
        new FlowerController(FlowerCommandInvoker.getFlowerCommandInvoker(model, view), view).processUserActions();
    }
}
