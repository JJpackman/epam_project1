package com.company.model.entity.decorator;

import com.company.model.entity.FlowerBouquet;
import com.company.model.entity.enums.AccessoriesPrices;

public class PapperWrapper extends FlowerBouquetDecorator {
    private FlowerBouquet bouquet;

    public PapperWrapper(FlowerBouquet bouquet) {
        this.bouquet = bouquet;
    }

    @Override
    public String getDescription() {
        return bouquet.getDescription() + ", wrapped in paper";
    }

    @Override
    public double getCost() {
        return bouquet.getCost() + AccessoriesPrices.PAPPER_WRAPPER.getCost();
    }
}
