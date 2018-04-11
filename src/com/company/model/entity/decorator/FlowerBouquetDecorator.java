package com.company.model.entity.decorator;

import com.company.model.entity.FlowerBouquet;

public abstract class FlowerBouquetDecorator extends FlowerBouquet {
    @Override
    public abstract String getDescription();

    @Override
    public abstract double getCost();
}
