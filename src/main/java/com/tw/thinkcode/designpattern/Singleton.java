package com.tw.thinkcode.designpattern;

public class Singleton {
  // Eager approach
  private static final Singleton INSTANCE = new Singleton();

  private Singleton() {}

  public static Singleton getInstance() {
    return INSTANCE;
  }
}

class StaticBlockSingleton {
  private static final StaticBlockSingleton INSTANCE;

  static {
    try {
      INSTANCE = new StaticBlockSingleton();
    } catch (Exception e) {
      throw new RuntimeException("Exception occurred in creating singleton instance");
    }
  }

  private StaticBlockSingleton() {}

  public static StaticBlockSingleton getInstance() {
    return INSTANCE;
  }
}
