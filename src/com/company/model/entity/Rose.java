package com.company.model.entity;

import com.company.model.entity.enums.FlowerPrices;

public class Rose extends Flower {
    public Rose(int lifeInDays, double stalkLengthInFeet) {
        super(lifeInDays, stalkLengthInFeet, "Rose");
    }

    public Rose() {
        this(10, 1.1);
    }

    @Override
    public double getCost() {
        return FlowerPrices.ROSE.getCost();
    }
}
