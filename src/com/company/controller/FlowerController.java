package com.company.controller;

import com.company.controller.command.FlowerCommandInvoker;
import com.company.controller.enums.Action;
import com.company.util.UserInputReader;
import com.company.view.ConsoleView;

public class FlowerController {
    private FlowerCommandInvoker commandInvoker;
    private ConsoleView view;

    public FlowerController(FlowerCommandInvoker commandInvoker, ConsoleView view) {
        this.commandInvoker = commandInvoker;
        this.view = view;
    }

    private String getMenuStr() {
        StringBuilder menuBuilder = new StringBuilder();

        for (Action action : Action.values()) {
            menuBuilder.append(action.toString()).append("\n");
        }

        return menuBuilder.toString();
    }

    public void processUserActions() {
        final String menuStr = getMenuStr();
        Action currentAction;

        do {
            try {
                view.printMsg(menuStr);

                currentAction = UserInputReader.readAction();

                if (currentAction == Action.EXIT) {
                    break;
                }

                commandInvoker.executeCommand(currentAction);
            } catch (Exception e) {
                view.printErrMsg(e.getMessage());
            }
        } while (true);
    }
}
