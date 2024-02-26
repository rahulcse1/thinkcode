package com.tw.thinkcode.hackerrank;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWIndow {
	private static int findSumMaxSubarrayOfSizeK(int[] a, int k) {

		if (a.length == 0 || k == 0)
			return 0;
		int sum = Integer.MIN_VALUE;

		int windowStart = 0;
		int windowSum = 0;

		for (int windowEnd = 0; windowEnd < a.length; windowEnd++) {
			windowSum += a[windowEnd];
			if (windowEnd - windowStart + 1 == k) {
				sum = Math.max(sum, windowSum);
				windowSum -= a[windowStart];
				windowStart++;
			}
		}
		return sum;
	}

	private static int[] findFirstNegativeNumberInSubarrayOfSizeK(int[] a, int k) {
		int len = a.length;
		int[] firstNegativeNumbers = new int[len - k + 1];
		int idx = 0;

		int windowStart = 0;
		Queue<Integer> q = new LinkedList<>();

		for (int windowEnd = 0; windowEnd < len; windowEnd++) {
			if (a[windowEnd] < 0) {
				q.add(a[windowEnd]);
			}

			if (windowEnd - windowStart + 1 == k) {
				if (q.isEmpty()) {
					firstNegativeNumbers[idx] = 0;
				} else {
					int num = q.peek();
					firstNegativeNumbers[idx] = num;
					if (num == a[windowStart]) {
						q.remove();
					}
				}
				windowStart++;
			}

		}

		return firstNegativeNumbers;
	}

	private static int[] maxofAllSubarray(int[] a, int k) {
		int len = a.length;
		int[] maxofsubarray = new int[len-k+1];
		int index = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < len; windowEnd++) {
			pq.add(a[windowEnd]);
			if(windowEnd - windowStart + 1 == k){
				int maxElement = pq.peek();
				maxofsubarray[index++] = maxElement;
				if(maxElement == a[windowStart]){
					pq.remove();
				}
				windowStart++;
			}
		}
		return maxofsubarray;
	}
}
