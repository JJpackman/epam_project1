package com.company.view;

import com.company.view.constant.ConsoleColorConstants;
import java.util.Collection;

public class ConsoleView {
    public void printMsg(String msg) {
        System.out.println(ConsoleColorConstants.ANSI_PURPLE + msg + ConsoleColorConstants.ANSI_RESET);
    }

    public void printObjects(Collection<?> objects) {
        for (Object o : objects) {
            System.out.println(ConsoleColorConstants.ANSI_PURPLE + o.toString());
        }

        System.out.print(ConsoleColorConstants.ANSI_RESET);
    }

    public void printErrMsg(String msg) {
        System.out.println(ConsoleColorConstants.ANSI_RED + msg + ConsoleColorConstants.ANSI_RESET);
    }
}
