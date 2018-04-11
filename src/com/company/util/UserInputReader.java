package com.company.util;

import com.company.controller.enums.Action;
import java.util.Scanner;

public class UserInputReader {
    private static final Scanner INPUT = new Scanner(System.in);

    private static Action getActionOrNull(int n) {
        for (Action a : Action.values()) {
            if (n == a.getNumber()) {
                return a;
            }
        }

        return null;
    }

    public static String readString() {
        return INPUT.nextLine();
    }

    public static Action readAction() throws Exception {
        int number;

        try {
            number = Integer.parseInt(INPUT.nextLine());
        } catch (NumberFormatException e) {
            throw new Exception("Illegal format of action number", e);
        }

        return getActionOrNull(number);
    }
}
