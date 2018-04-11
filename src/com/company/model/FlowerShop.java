package com.company.model;

import com.company.model.entity.*;
import java.util.*;

public class FlowerShop {
    private List<FlowerBouquet> bouquets;

    public FlowerShop() {
        bouquets = new ArrayList<>();
    }

    public <T extends Flower> void addBouquet(T[] flowers, String description) {
        FlowerBouquet<T> newBouquet = new FlowerBouquet<>(description);

        for (T flower : flowers) {
            newBouquet.addFlower(flower);
        }

        bouquets.add(newBouquet);
    }

    public FlowerBouquet[] getBouquets() {
        return bouquets.toArray(new FlowerBouquet[0]);
    }
}
