package com.company.controller.command;

import com.company.model.FlowerShop;
import com.company.view.ConsoleView;
import java.util.Arrays;

public class ShowBouquetsCommand implements ConsumerCommand {
    private static final String ENTRY_MSG = "List of bouquets:";
    private FlowerShop model;
    private ConsoleView view;

    public ShowBouquetsCommand(FlowerShop model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void execute() {
        view.printMsg(ENTRY_MSG);
        view.printObjects(Arrays.asList(model.getBouquets()));
    }
}
