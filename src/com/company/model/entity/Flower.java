package com.company.model.entity;

public abstract class Flower implements ICostable {
    private int lifeInDays;
    private double stalkLengthInFeet;
    private String name;

    public Flower(int lifeInDays, double stalkLengthInFeet, String name) {
        this.lifeInDays = lifeInDays;
        this.stalkLengthInFeet = stalkLengthInFeet;
        this.name = name;
    }

    public final void shortenLifeForADay() {
        lifeInDays--;
    }

    public final boolean isAlive() {
        return lifeInDays > 0;
    }

    public int getLifeInDays() {
        return lifeInDays;
    }

    public double getStalkLengthInFeet() {
        return stalkLengthInFeet;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s has %.2f feet in height and live %d, cost %.2f",
                name, stalkLengthInFeet, lifeInDays, getCost());
    }
}
