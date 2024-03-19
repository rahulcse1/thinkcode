package com.tw.thinkcode.hackerrank;

public class BST {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
    }
  }

  public static Node insert(Node root, int data) {
    if (root == null) {
      root = new Node(data);
    }
    if (root.data > data) {
      root.left = insert(root.left, data);
    } else {
      root.right = insert(root.right, data);
    }
    return root;
  }

  public static Node delete(Node root, int val) {
    if (root.data > val) {
      root.left = delete(root.left, val);
    } else if (root.data < val) {
      root.right = delete(root.right, val);
    } else {
      // root.data = val
      if (root.left == null && root.right == null) {
        return null;
      }
      if (root.left == null) {
        return root.right;
      }
      if (root.right == null) {
        return root.left;
      }
      Node IS = inOrderSuccessor(root.right);
      root.data = IS.data;
      root.right = delete(root.right, IS.data);
    }
    return root;
  }

  public static Node inOrderSuccessor(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  public static void main(String[] args) {
    int[] values = {5, 1, 3, 4, 2, 7};
    Node root = null;
    for (int value : values) {
      root = insert(root, value);
    }
  }
}
