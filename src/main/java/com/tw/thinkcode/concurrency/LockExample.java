package com.tw.thinkcode.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private static final Lock lock = new ReentrantLock();
    private static void acquireLockAndPrint(String threadName) {
        lock.lock();
        try {
            System.out.println(threadName + " acquired the lock");
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
         finally {
            lock.unlock();
            System.out.println(threadName + " released the lock");
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> acquireLockAndPrint("Thread 1"));
        Thread t2 = new Thread(() -> acquireLockAndPrint("Thread 2"));
        t1.start();
        t2.start();
    }
}
