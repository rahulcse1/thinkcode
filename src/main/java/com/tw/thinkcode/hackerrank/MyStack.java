package com.tw.thinkcode.hackerrank;

public class MyStack<T> {
  private static class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }

  private Node<T> top;

  public T pop() {
    if (top == null) throw new RuntimeException("Stack is empty");
    T item = top.data;
    top = top.next;
    return item;
  }

  public void push(T item) {
    Node<T> t = new Node<T>(item);
    t.next = top;
    top = t;
  }

  public T peek() {
    if (top == null) throw new RuntimeException("Stack is empty");
    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public static void main(String[] args) {
    MyStack<Integer> stack = new MyStack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
