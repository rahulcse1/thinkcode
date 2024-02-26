package com.tw.thinkcode.hackerrank;

import java.util.Arrays;

public class MinimumDaysToBloom {

/*
    You are given an integer array bloomDay, an integer m and an integer k.
    You want to make m bouquets. To make a bouquet, you need to use
    k adjacent flowers from the garden.
    The garden consists of n flowers, the ith flower will bloom in the bloomDay[i]
    and then can be used in exactly one bouquet.
    Return the minimum number of days you need to wait to be able to make
    m bouquets from the garden. If it is impossible to make m bouquets return -1.
*/
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < (long) m * k) {
            return -1;
        }
        int lp = Arrays.stream(bloomDay).min().getAsInt();
        int rp = Arrays.stream(bloomDay).max().getAsInt();

        while (lp < rp) {
            int mid = lp + (rp - lp) / 2;
            int bouquets = getBouquets(bloomDay, mid, k);
            if (bouquets < m) {
                lp = mid + 1;
            } else {
                rp = mid;
            }
        }
        return lp;
    }

    private int getBouquets(int[] bloomDay, int day, int k) {
        int bouquets = 0, flowersCollected = 0;
        for (int val : bloomDay) {
            if (val <= day) {
                flowersCollected++;
            } else {
                flowersCollected = 0;
            }
            if (flowersCollected == k) {
                bouquets++;
                flowersCollected = 0;
            }
        }
        return bouquets;
    }

    public static void main(String[] args) {
        MinimumDaysToBloom bloom = new MinimumDaysToBloom();
        System.out.println(bloom.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
    }
}