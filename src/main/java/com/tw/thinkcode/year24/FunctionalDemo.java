package com.tw.thinkcode.year24;

@FunctionalInterface
interface MyFunctionalInterface {
  void myMethod();
}

public class FunctionalDemo {
  public static void main(String[] args) {
    MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Hello World");
    myFunctionalInterface.myMethod();
  }
}
