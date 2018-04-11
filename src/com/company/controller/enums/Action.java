package com.company.controller.enums;

public enum Action {
    ADD(1, "Add bouquet"),
    SHOW(2, "Get a list of bouquets"),
    SORT_BY_FRESHNESS(3, "Sort flowers in specified bouquet by freshness"),
    FIND(4, "Find flower in specified bouquet in range of stalk length"),
    EXIT(5, "Exit");

    private final String description;
    private final int number;

    Action(int number, String description) {
        this.description = description;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("%d) %s", number, description);
    }
}