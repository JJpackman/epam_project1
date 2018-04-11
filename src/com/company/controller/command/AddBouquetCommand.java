package com.company.controller.command;

import com.company.model.FlowerShop;
import com.company.model.entity.Flower;
import com.company.model.entity.factory.FlowerFactory;
import com.company.util.UserInputReader;
import com.company.view.ConsoleView;
import java.util.*;

public class AddBouquetCommand implements ConsumerCommand {
    private FlowerShop model;
    private ConsoleView view;

    public AddBouquetCommand(FlowerShop model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    private Flower getFlower(String name) throws Exception {
        view.printMsg("Do you wan't to add manually stalk length and life in days? (yes)" +
                " [anything except 'yes' considered as not]");
        final String decision = UserInputReader.readString();
        if (decision.toLowerCase().matches("yes")) {
            int lifeInDays;
            try {
                view.printMsg("Enter life in days:");
                lifeInDays = Integer.parseInt(UserInputReader.readString());
            } catch (NumberFormatException e) {
                throw new Exception("Illegal format of life in days", e);
            }

            double stalkLength;
            try {
                view.printMsg("Enter stalk length in feet:");
                stalkLength = Double.parseDouble(UserInputReader.readString());
            } catch (NumberFormatException e) {
                throw new Exception("Illegal format of stalk length", e);
            }

            return FlowerFactory.getFlower(name, lifeInDays, stalkLength);
        }

        return FlowerFactory.getFlower(name);
    }

    @Override
    public void execute() throws Exception {
        view.printMsg("Enter description of flower bouquet:");
        final String description = UserInputReader.readString();
        final List<Flower> flowers = new ArrayList<>();

        view.printMsg("Enter type of bouquet (single, mixed):");
        final String type = UserInputReader.readString();

        if (type.equalsIgnoreCase("single")) {
            view.printMsg("Enter name of flower:");
            final String nameOfFlowers = UserInputReader.readString();

            do {
                view.printMsg("Enter 'exit' if enough:");
                String decision = UserInputReader.readString();
                flowers.add(getFlower(nameOfFlowers));

                if (decision.equalsIgnoreCase("exit")) {
                    break;
                }
            } while (true);

            model.addBouquet(flowers.toArray(new Flower[0]), description);
        } else if (type.equalsIgnoreCase("mixed")) {
            do {
                view.printMsg("Enter 'exit' if enough:");
                String decision = UserInputReader.readString();
                if (decision.equalsIgnoreCase("exit")) {
                    break;
                }

                view.printMsg("Enter name of flower:");
                flowers.add(getFlower(UserInputReader.readString()));
            } while (true);

            model.addBouquet(flowers.toArray(new Flower[0]), description);
        } else {
            throw new Exception("Illegal type of bouquet:");
        }
    }
}
