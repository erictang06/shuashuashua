package com.root.Tree;

public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
    root.val = ' ';
  }

  public void insert(String word) {
    TrieNode ws = root;
    for (int i=0; i<word.length(); i++) {
      char ch = word.charAt(i);
      if (ws.children[ch - 'a'] == null) {
        ws.children[ch - 'a'] = new TrieNode(ch);
      }
      ws = ws.children[ch - 'a'];
    }

    ws.isWord = true;
  }

  public boolean search(String word) {
    TrieNode ws = root;
    for (int i=0; i<word.length(); i++) {
      char ch = word.charAt(i);
      if (ws.children[ch - 'a'] == null) {
        return false;
      }
      ws = ws.children[ch - 'a'];
    }

    return ws.isWord;
  }

}

class TrieNode {
  public char val;
  public TrieNode[] children = new TrieNode[26];
  public boolean isWord;

  public TrieNode() {

  }

  public TrieNode(char ch) {
    TrieNode root = new TrieNode();
    root.val = ch;
  }
}
