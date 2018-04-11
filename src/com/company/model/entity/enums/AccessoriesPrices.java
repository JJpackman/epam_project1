package com.company.model.entity.enums;

import com.company.model.entity.ICostable;

public enum AccessoriesPrices implements ICostable {
    PAPPER_WRAPPER() {
        @Override
        public double getCost() {
            return 20;
        }
    },
    RIBBON() {
        @Override
        public double getCost() {
            return 10;
        }
    };
}
