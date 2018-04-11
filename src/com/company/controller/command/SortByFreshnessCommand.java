package com.company.controller.command;

import com.company.controller.command.helper.ChooseBouquetCommand;
import com.company.model.FlowerShop;
import com.company.model.entity.FlowerBouquet;
import com.company.util.FlowerService;
import com.company.view.ConsoleView;
import java.util.Arrays;

public class SortByFreshnessCommand implements ConsumerCommand {
    private FlowerShop model;
    private ConsoleView view;
    private SupplierCommand<FlowerBouquet> supplierHelperCommand;

    public SortByFreshnessCommand(FlowerShop model, ConsoleView view) {
        this.model = model;
        this.view = view;
        this.supplierHelperCommand = new ChooseBouquetCommand(model, view);
    }

    @Override
    public void execute() throws Exception {
        FlowerService.sortFlowersByFreshness(supplierHelperCommand.execute());
        view.printObjects(Arrays.asList(model.getBouquets()));
    }
}
