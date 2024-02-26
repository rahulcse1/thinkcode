package com.tw.thinkcode.hackerrank;

import java.util.Arrays;

public class KokoEatingBanana {

	public static int minEatingSpeed(int[] piles, int h) {
		int lp = 1;
        int rp = Arrays.stream(piles).max().getAsInt();
        while(lp <= rp) {
        	int mid = lp + (rp -lp) /2;
        	if(canEatInTime(piles, mid, h)) {
        		rp = mid - 1;
        	}else {
        		lp = mid + 1;
        	}
        }
        return lp;
	}
	
	private static boolean canEatInTime(int[] piles, int mid, int h) {
		int hours = 0;
		for(int pile: piles) {
			int div = pile / mid;
			hours += div;
			if(pile % mid != 0) {
				++hours;
			}				
		}
		return hours <= h;
	}
	public static void main(String[] args) {
		int[] piles = new int[] {805306368,805306368,805306368};
		int h = 1000000000;
		System.out.println(minEatingSpeed(piles, h));
	}
}
