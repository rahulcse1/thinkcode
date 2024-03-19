package com.tw.thinkcode.hackerrank;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

  static void levelOrderTravel(Node root) {
    if (root == null) return;
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node tempNode = queue.poll();
      System.out.print(tempNode.data + " ");
      if (tempNode.left != null) {
        queue.add(tempNode.left);
      }
      if (tempNode.right != null) {
        queue.add(tempNode.right);
      }
    }
  }

  static int countNodes(Node root) {
    if (root == null) return 0;
    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  static int sumOfNodes(Node root) {
    if (root == null) return 0;
    return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
  }

  static int height(Node root) {
    if (root == null) return 0;
    int lh = height(root.left);
    int rh = height(root.right);
    return Math.max(lh, rh) + 1;
  }

  static int treeDiameter(Node root) {
    if (root == null) return 0;
    int diam1 = treeDiameter(root.left);
    int diam2 = treeDiameter(root.right);
    int diam3 = height(root.left) + height(root.right) + 1;
    return Math.max(diam3, Math.max(diam1, diam2));
  }

  static class TreeInfo {
    int h;
    int diam;

    TreeInfo(int h, int diam) {
      this.h = h;
      this.diam = diam;
    }
  }

  public static TreeInfo diamter(Node root) {
    if (root == null) return new TreeInfo(0, 0);
    TreeInfo left = diamter(root.left);
    TreeInfo right = diamter(root.right);
    int h = Math.max(left.h, right.h) + 1;
    int diam1 = left.diam;
    int diam2 = right.diam;
    int diam3 = left.h + right.h + 1;
    int myDiam = Math.max(Math.max(diam1, diam2), diam3);
    return new TreeInfo(h, myDiam);
  }

  static boolean isIdentical(Node root, Node subRoot) {
    if (root == null && subRoot == null) {
      return true;
    }
    if (root == null || subRoot == null) {
      return false;
    }
    if (root.data == subRoot.data) {
      return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }
    return false;
  }

  static boolean isSubTree(Node root, Node subRoot) {
    if (subRoot == null) return true;
    if (root == null) return false;
    if (root.data == subRoot.data && (isIdentical(root, subRoot))) {
      return true;
    }
    return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    levelOrderTravel(root);
    System.out.println();
    System.out.println(countNodes(root));
    System.out.println();
    System.out.println(sumOfNodes(root));
    System.out.println();
    System.out.println(height(root));
    System.out.println();
    System.out.println(diamter(root).diam);
  }
}
