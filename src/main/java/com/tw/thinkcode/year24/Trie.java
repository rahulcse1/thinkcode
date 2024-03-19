package com.tw.thinkcode.year24;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Trie {
  static class Node {
    char c;
    boolean eow;
    Node[] children;

    public Node(char c) {
      this.c = c;
      eow = false;
      children = new Node[26];
    }
  }

  private final Node root;

  public Trie() {
    root = new Node('\0');
  }

  public void insert(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (curr.children[c - 'a'] == null) {
        curr.children[c - 'a'] = new Node(c);
      }
      curr = curr.children[c - 'a'];
    }
    curr.eow = true;
  }

  public boolean search(String word) {
    Node node = getNode(word);
    return node != null && node.eow;
  }

  public boolean startsWith(String prefix) {
    return getNode(prefix) != null;
  }

  private Node getNode(String word) {
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (curr.children[c - 'a'] == null) return null;
      curr = curr.children[c - 'a'];
    }
    return curr;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("amarjeet");
    trie.insert("amarpal");
    trie.insert("amapal");
    trie.insert("amar");
    log.info("{}", trie.search("amapal"));
    log.info("{}", trie.startsWith("amae"));
  }
}
