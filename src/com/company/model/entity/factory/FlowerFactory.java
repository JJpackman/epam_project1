package com.company.model.entity.factory;

import com.company.model.entity.*;

public class FlowerFactory {
    public static Flower getFlower(String name, int lifeInDays, double stalkLengthInFeet) {
        Flower flower = null;

        switch (name.toLowerCase()) {
            case "rose":
                flower = new Rose(lifeInDays, stalkLengthInFeet);
                break;
            case "tulip":
                flower = new Tulip(lifeInDays, stalkLengthInFeet);
                break;
        }

        return flower;
    }

    public static Flower getFlower(String name) {
        Flower flower = null;

        switch (name.toLowerCase()) {
            case "rose":
                flower = new Rose();
                break;
            case "tulip":
                flower = new Tulip();
                break;
        }

        return flower;

    }
}
