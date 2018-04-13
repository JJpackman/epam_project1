package com.company.controller.command;

import com.company.model.FlowerShop;
import com.company.model.entity.Flower;
import com.company.model.entity.factory.FlowerFactory;
import com.company.util.UserInputReader;
import com.company.view.ConsoleView;
import java.util.*;

import static com.company.controller.command.AddBouquetCommand.AddBouquetCommandConstants.*;

public class AddBouquetCommand implements ConsumerCommand {
    private FlowerShop model;
    private ConsoleView view;

    public AddBouquetCommand(FlowerShop model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    private Flower getFlower(String name) throws Exception {
        view.printMsg(FLOWER_QUESTION_MSG);
        final String decision = UserInputReader.readString();
        if (decision.toLowerCase().matches(FLOWER_ANSWER_MSG)) {
            int lifeInDays;
            try {
                view.printMsg(FLOWER_ENTRY_MESSAGES[0]);
                lifeInDays = Integer.parseInt(UserInputReader.readString());
            } catch (NumberFormatException e) {
                throw new Exception(FLOWER_ERR_MESSAGES[0], e);
            }

            double stalkLength;
            try {
                view.printMsg(FLOWER_ENTRY_MESSAGES[1]);
                stalkLength = Double.parseDouble(UserInputReader.readString());
            } catch (NumberFormatException e) {
                throw new Exception(FLOWER_ERR_MESSAGES[1], e);
            }

            return FlowerFactory.getFlower(name, lifeInDays, stalkLength);
        }

        return FlowerFactory.getFlower(name);
    }

    private void fillSingleBouquet(Collection<Flower> flowers, String nameOfFlowers) throws Exception {
        do {
            view.printMsg(FILL_BOUQUET_QUESTION_MSG);
            String decision = UserInputReader.readString();
            if (decision.equalsIgnoreCase(FILL_BOUQUET_ANSWER_MSG)) {
                break;
            }
            
            flowers.add(getFlower(nameOfFlowers));
        } while (true);
    }

    private void fillMixedBouquet(Collection<Flower> flowers) throws Exception {
        do {
            view.printMsg(FILL_BOUQUET_QUESTION_MSG);
            String decision = UserInputReader.readString();
            if (decision.equalsIgnoreCase(FILL_BOUQUET_ANSWER_MSG)) {
                break;
            }

            view.printMsg(FILL_MIXED_ENTRY_MSG);
            flowers.add(getFlower(UserInputReader.readString()));
        } while (true);
    }

    @Override
    public void execute() throws Exception {
        view.printMsg(BOUQUET_ENTRY_MESSAGES[0]);
        final String description = UserInputReader.readString();
        final List<Flower> flowers = new ArrayList<>();

        view.printMsg(BOUQUET_ENTRY_MESSAGES[1]);
        final String type = UserInputReader.readString();

        if (type.equalsIgnoreCase(BOUQUET_TYPES[0])) {
            view.printMsg(BOUQUET_ENTRY_MESSAGES[2]);
            fillSingleBouquet(flowers, UserInputReader.readString());
            model.addBouquet(flowers.toArray(new Flower[0]), description);
        } else if (type.equalsIgnoreCase(BOUQUET_TYPES[1])) {
            fillMixedBouquet(flowers);
            model.addBouquet(flowers.toArray(new Flower[0]), description);
        } else {
            throw new Exception(BOUQUET_ERR_MSG);
        }
    }

    public final static class AddBouquetCommandConstants {
        private AddBouquetCommandConstants() {}

        public static final String[] FLOWER_ERR_MESSAGES = {
                "Illegal format of life in days",
                "Illegal format of stalk length"
        };
        public static final String[] FLOWER_ENTRY_MESSAGES = {
                "Enter life in days:",
                "Enter stalk length in feet:"
        };
        public static final String FLOWER_QUESTION_MSG = "Do you wan't to add manually stalk length and life in days? (yes)" +
                " [anything except 'yes' considered as not]";
        public static final String FLOWER_ANSWER_MSG = "yes";
        public static final String[] BOUQUET_TYPES = { "single", "mixed" };
        public static final String BOUQUET_ERR_MSG = "Illegal type of bouquet";
        public static final String[] BOUQUET_ENTRY_MESSAGES = {
                "Enter description of flower bouquet:",
                String.format("Enter type of bouquet (%s, %s):", BOUQUET_TYPES[0], BOUQUET_TYPES[1]),
                "Enter name of flower:"
        };
        public static final String FILL_BOUQUET_ANSWER_MSG = "exit";
        public static final String FILL_BOUQUET_QUESTION_MSG = "Enter 'exit' if enough:";
        public static final String FILL_MIXED_ENTRY_MSG = "Enter name of flower:";
    }
}
