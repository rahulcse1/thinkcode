package com.tw.thinkcode.hackerrank;

import java.util.Arrays;

public class CapacityToShip {

    /*
    A conveyor belt has packages that must be shipped from
    one port to another within days.
    The ith package on the conveyor belt has a weight of weights[i].
    Each day, we load the ship with packages on the conveyor belt
    (in the order given by weights).
    We may not load more weight than the maximum weight capacity of the ship.
    Return the least weight capacity of the ship
    that will result in all the packages on the conveyor belt being shipped
    within days.
     */
    public int shipWithinDays(int[] weights, int days) {
        int lp = Arrays.stream(weights).max().getAsInt();
        int rp = Arrays.stream(weights).sum();
        while (lp < rp) {
            int max = lp + (rp - lp) / 2;
            boolean minimumCap = minimumCapacity(weights, max, days);
            if (minimumCap) {
                rp = max;
            } else {
                lp = max + 1;
            }
        }
        return lp;
    }

    private boolean minimumCapacity(int[] weights, int max, int days) {
        int weight = 0;
        int noOfdays = 1;
        for (int j : weights) {
            if (j + weight <= max) {
                weight += j;
            } else {
                weight = j;
                noOfdays++;
                if (noOfdays > days) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CapacityToShip ship = new CapacityToShip();
        int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(ship.shipWithinDays(weights, 5));
    }
}
