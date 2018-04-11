package com.company.model.entity;

import com.company.model.entity.enums.FlowerPrices;

public class Tulip extends Flower {
    public Tulip(int lifeInDays, double stalkLengthInFeet) {
        super(lifeInDays, stalkLengthInFeet, "Tulip");
    }

    public Tulip() {
        this(22, 1.5);
    }

    @Override
    public double getCost() {
        return FlowerPrices.TULIP.getCost();
    }
}
