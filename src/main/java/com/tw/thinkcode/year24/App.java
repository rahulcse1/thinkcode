package com.tw.thinkcode.year24;

import java.util.ArrayList;
import java.util.List;

public class App {
  public int calculateContainers(List<Car> cars, int containerWeight, int containerLength) {
    List<Container> containers = new ArrayList<>();
    Container currentContainer = null;

    for (Car car : cars) {
      if (currentContainer == null || !currentContainer.canFit(car)) {
        currentContainer = new Container();
        containers.add(currentContainer);
      }
      currentContainer.addCar(car);
    }

    return containers.size();
  }

  public static void main(String[] args) {
    App app = new App();
    List<Car> cars = new ArrayList<>();
    cars.add(new Car(1, 1));
    cars.add(new Car(1, 1));
    cars.add(new Car(1, 1));
    System.out.println(app.calculateContainers(cars, 2, 2));
  }
}
