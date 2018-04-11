package com.company.controller.command;

import com.company.controller.enums.Action;
import com.company.model.FlowerShop;
import com.company.view.ConsoleView;
import java.util.*;

public class FlowerCommandInvoker {
    private final Map<Action, ConsumerCommand> consumerCommands = new HashMap<>();
    private final FlowerShop model;
    private final ConsoleView view;

    public void addCommand(Action action, ConsumerCommand command) {
        if (!consumerCommands.containsKey(action)) {
            consumerCommands.put(action, command);
        }
    }

    public FlowerCommandInvoker(FlowerShop model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void executeCommand(Action action) throws Exception {
        try {
            consumerCommands.get(action).execute();
        } catch (NullPointerException e) {
            throw new Exception("Command not found", e);
        }
    }

    public static FlowerCommandInvoker getFlowerCommandInvoker(final FlowerShop model, final ConsoleView view) {
        return new FlowerCommandInvoker(model, view) {
            {
                addCommand(Action.ADD, new AddBouquetCommand(model, view));
                addCommand(Action.SHOW, new ShowBouquetsCommand(model, view));
                addCommand(Action.SORT_BY_FRESHNESS, new SortByFreshnessCommand(model, view));
                addCommand(Action.FIND, new FindFlowerCommand(model, view));
            }
        };
    }
}
