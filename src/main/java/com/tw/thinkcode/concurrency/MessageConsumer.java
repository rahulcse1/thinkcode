package com.tw.thinkcode.concurrency;

import java.util.concurrent.BlockingQueue;

public class MessageConsumer implements Runnable {

  private BlockingQueue<Message> queue;

  public MessageConsumer(BlockingQueue<Message> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    try {
      Message message;
      while ((message = queue.take()).getMessage() != "exit") {
        Thread.sleep(10);
        System.out.println("Consumed " + message.getMessage());
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
