package com.company.model.entity.decorator;

import com.company.model.entity.FlowerBouquet;
import com.company.model.entity.enums.AccessoriesPrices;

public class Ribbon extends FlowerBouquetDecorator {
    private FlowerBouquet bouquet;

    public Ribbon(FlowerBouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public String getDescription() {
        return bouquet.getDescription() + ", ribboned";
    }

    @Override
    public double getCost() {
        return bouquet.getCost() + AccessoriesPrices.RIBBON.getCost();
    }
}
