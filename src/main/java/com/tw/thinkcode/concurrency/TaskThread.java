package com.tw.thinkcode.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

class TaskA implements Runnable {
    @Override
    public void run() {
        System.out.println("Task A is running");
    }
}

class TaskB implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Task B is running";
    }
}

public class TaskThread {

    static void completableTask() {
        CompletableFuture<String> name = CompletableFuture.supplyAsync(() -> "AMARJEET");

    CompletableFuture<Integer> nameLength = name.thenApply(value -> {
        printCurrentThread();
        return value.length();
    });

    nameLength.thenAccept(value -> {
        System.out.println("Name length is: " + value);
    });

        CompletableFuture<String> name1 = CompletableFuture.supplyAsync(() -> "AMARJEET");
        CompletableFuture<Integer> nameLength1 = name1.thenApplyAsync(value -> {
            printCurrentThread();
            return value.length();
        });

        nameLength1.thenAccept(value -> {
            System.out.println("Name length is: " + value);
        });
    
    }
    private static void printCurrentThread() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws Exception{
        completableTask();
    }
    
}
