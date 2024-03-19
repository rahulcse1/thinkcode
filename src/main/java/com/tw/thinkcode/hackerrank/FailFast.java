package com.tw.thinkcode.hackerrank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFast {
  public static void main(String[] args) {
    ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    Iterator<Integer> iterator = numbers.iterator();
    while (iterator.hasNext()) {
      Integer number = iterator.next();
      System.out.println(number);
      numbers.add(50);
    }
  }
}
