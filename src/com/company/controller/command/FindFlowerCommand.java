package com.company.controller.command;

import com.company.controller.command.helper.ChooseBouquetCommand;
import com.company.model.FlowerShop;
import com.company.model.entity.*;
import com.company.util.*;
import com.company.view.ConsoleView;
import java.util.Arrays;

public class FindFlowerCommand implements ConsumerCommand {
    private static final String[] ENTRY_MESSAGES = {
            "Enter lower bound of stalk length:",
            "Enter higher bound of stalk length (exclusive):"
    };
    private static final String RESULT_MSG = "Flower in specified stalk length range not found";
    private static final String ERROR_MSG = "Illegal format of stalk length bounds";
    private FlowerShop model;
    private ConsoleView view;
    private SupplierCommand<FlowerBouquet> supplierHelperCommand;

    public FindFlowerCommand(FlowerShop model, ConsoleView view) {
        this.model = model;
        this.view = view;
        this.supplierHelperCommand = new ChooseBouquetCommand(model, view);
    }

    @Override
    public void execute() throws Exception {
        try {
            FlowerBouquet bouquet = supplierHelperCommand.execute();

            view.printMsg(ENTRY_MESSAGES[0]);
            double from = Double.parseDouble(UserInputReader.readString());

            view.printMsg(ENTRY_MESSAGES[1]);
            double to = Double.parseDouble(UserInputReader.readString());
            Flower[] flower = { FlowerService.findSomeFlowerWithStalkLengthInRange(bouquet, from, to) };

            if (flower[0] == null) {
                view.printMsg(RESULT_MSG);
            } else {
                view.printObjects(Arrays.asList(flower));
            }
        } catch (NumberFormatException e) {
            throw new Exception(ERROR_MSG, e);
        }
    }
}
