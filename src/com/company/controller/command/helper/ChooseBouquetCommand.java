package com.company.controller.command.helper;

import com.company.controller.command.SupplierCommand;
import com.company.model.FlowerShop;
import com.company.model.entity.FlowerBouquet;
import com.company.util.UserInputReader;
import com.company.view.ConsoleView;

public class ChooseBouquetCommand implements SupplierCommand<FlowerBouquet> {
    private static final String ENTRY_MSG = "Enter number of flower bouquet to choose";
    private static final String ERROR_MSG = "Flower bouquets at %d number not found";
    private FlowerShop model;
    private ConsoleView view;

    public ChooseBouquetCommand(FlowerShop model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public FlowerBouquet execute() throws Exception {
        view.printMsg(ENTRY_MSG);
        int bouquetNumber = Integer.parseInt(UserInputReader.readString());

        FlowerBouquet[] bouquets = model.getBouquets();
        int startNumber = 1;
        int endNumber = bouquets.length;

        if (bouquetNumber >= startNumber && bouquetNumber <= endNumber) {
            return model.getBouquets()[bouquetNumber];
        }

        throw new Exception(String.format(ERROR_MSG, bouquetNumber));
    }
}
