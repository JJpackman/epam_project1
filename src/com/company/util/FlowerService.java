package com.company.util;

import com.company.model.entity.*;
import java.util.Comparator;

public class FlowerService {
    public static void sortFlowersByFreshness(FlowerBouquet bouquet) {
        bouquet.sortFlowers(new Comparator<Flower>() {
            @Override
            public int compare(Flower f1, Flower f2) {
                return f2.getLifeInDays() - f1.getLifeInDays();
            }
        });
    }

    public static Flower findSomeFlowerWithStalkLengthInRange(FlowerBouquet bouquet, double from, double to) {
        Flower[] flowers = bouquet.getFlowers();

        for (Flower checkedFlower : flowers) {
            final int fromRes = Double.compare(checkedFlower.getStalkLengthInFeet(), from);
            final int toRes = Double.compare(checkedFlower.getStalkLengthInFeet(), to);

            if (fromRes >= 0 && toRes == -1) {
                return checkedFlower;
            }
        }

        return null;
    }
}
