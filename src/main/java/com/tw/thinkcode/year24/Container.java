package com.tw.thinkcode.year24;


public class Container {
  int remainingWeight = 5;
  int remainingLength = 10;

  public boolean canFit(Car car) {
    return remainingWeight >= car.weight && remainingLength >= car.length;
  }

  public void addCar(Car car) {
    remainingWeight -= car.weight;
    remainingLength -= car.length;
  }
}
