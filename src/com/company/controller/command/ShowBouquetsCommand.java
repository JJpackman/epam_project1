package com.company.controller.command;

import com.company.model.FlowerShop;
import com.company.model.entity.FlowerBouquet;
import com.company.view.ConsoleView;
import java.util.Arrays;

public class ShowBouquetsCommand implements ConsumerCommand {
    private static final String ENTRY_MSG = "List of bouquets:";
    private static final String EMPTY_MSG = "No bouquets";
    private FlowerShop model;
    private ConsoleView view;

    public ShowBouquetsCommand(FlowerShop model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void execute() {
        view.printMsg(ENTRY_MSG);
        final FlowerBouquet[] bouquets = model.getBouquets();

        if (bouquets.length == 0) {
            view.printMsg(EMPTY_MSG);
        } else {
            StringBuilder strBouquets = new StringBuilder();

            for (int i = 0; i < bouquets.length; i++) {
                strBouquets = strBouquets.append(i + 1).append(") ").append(bouquets[i]).append("\n");
            }

            view.printObjects(Arrays.asList(strBouquets.toString()));
        }
    }
}
