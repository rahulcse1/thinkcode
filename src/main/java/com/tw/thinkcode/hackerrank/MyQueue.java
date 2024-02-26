package com.tw.thinkcode.hackerrank;

public class MyQueue <T>{
    private static class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T data){
            this.data = data;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    public T remove(){
        if(head == null) throw new RuntimeException("Queue is empty");
        T item = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return item;
    }
    public void add(T item){
        Node<T> t = new Node<>(item);
        if(tail != null){
            tail.next = t;
        }
        tail = t;
        if(head == null){
            head = tail;
        }
    }
    public T peek(){
        if(head == null) throw new RuntimeException("Queue is empty");
        return head.data;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
