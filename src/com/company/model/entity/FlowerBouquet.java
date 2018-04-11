package com.company.model.entity;

import java.util.*;

public class FlowerBouquet<T extends Flower> implements ICostable {
    private List<T> flowers;
    private String description;

    public FlowerBouquet(String description) {
        this.description = description;
        this.flowers = new ArrayList<>();
    }

    public FlowerBouquet() {
        this("");
    }

    public void addFlower(T newFlower) {
        flowers.add(newFlower);
    }

    @SuppressWarnings("unchecked")
    public T[] getFlowers() {
        return (T[]) flowers.toArray(new Flower[0]);
    }

    public void sortFlowers(Comparator<Flower> comparator) {
        Collections.sort(flowers, comparator);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        StringBuilder bouquetStr = new StringBuilder();

        bouquetStr.append(description).append("\n");
        for (T flower : flowers) {
            bouquetStr.append(flower.toString()).append("\n");
        }

        return bouquetStr.toString();
    }

    @Override
    public double getCost() {
        double totalCost = 0.0;

        for (T flower : flowers) {
            totalCost += flower.getCost();
        }

        return totalCost;
    }


}
