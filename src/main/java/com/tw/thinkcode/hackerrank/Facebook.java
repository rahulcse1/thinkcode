package com.tw.thinkcode.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Facebook {
  double powFun(double x, int n) {
    if (n == 0) return 1;
    if (n == 1) return x;

    if (n % 2 == 0) {
      return powFun(x * x, n / 2);
    } else if (n % 2 == 1) {
      return x * powFun(x, n - 1);
    } else {
      return 1 / powFun(x, -n);
    }
  }

  int visibleNode(Node root) {
    if (root == null) return 0;
    return 1 + Math.max(visibleNode(root.left), visibleNode(root.right));
  }

  String rotationalCipher(String input, int rotationFactor) {
    StringBuilder response = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (Character.isUpperCase(c)) {
        char ch = (char) ((c + rotationFactor - 65) % 26 + 65);
        response.append(ch);
      } else if (Character.isLowerCase(c)) {
        char ch = (char) ((c + rotationFactor - 97) % 26 + 97);
        response.append(ch);
      } else if (Character.isDigit(c)) {
        int num = Character.getNumericValue(c) + rotationFactor;
        if (num > 9) {
          // 12
          num = num % 10;
        }
        response.append(num);
      } else {
        response.append(c);
      }
    }
    return response.toString();
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return root;
    if (root.val == p.val || root.val == q.val) return root;

    var leftLca = lowestCommonAncestor(root.left, p, q);
    var rightLca = lowestCommonAncestor(root.right, p, q);

    if (leftLca != null && rightLca != null) {
      return root;
    }
    return leftLca != null ? leftLca : rightLca;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 0; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordDict.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  static class ListNode {
    int val;
    ListNode next;
  }

  ListNode findMiddleOfList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  ListNode reverseListRecursive(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = reverseListRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;

    ListNode middleOfList = findMiddleOfList(head);
    ListNode secondHalfOfList = reverseList(middleOfList.next);

    ListNode firstHalf = head;
    ListNode secondHalf = secondHalfOfList;
    while (secondHalf != null) {
      if (firstHalf.val != secondHalf.val) {
        return false;
      }
      firstHalf = firstHalf.next;
      secondHalf = secondHalf.next;
    }
    return true;
  }

  public static void main(String[] args) {
    // String input = "Zebra-493?";
    Facebook facebook = new Facebook();
    var wordDict = new ArrayList<String>();
    wordDict.add("leet");
    wordDict.add("code");
    System.out.println(facebook.wordBreak("leetcode", wordDict));
  }
}
