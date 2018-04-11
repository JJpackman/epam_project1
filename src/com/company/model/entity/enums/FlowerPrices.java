package com.company.model.entity.enums;

import com.company.model.entity.ICostable;

public enum FlowerPrices implements ICostable {
    ROSE() {
        @Override
        public double getCost() {
            return 30;
        }
    },
    TULIP() {
        @Override
        public double getCost() {
            return 7.80;
        }
    };
}
