package com.root.List;

/**
 * Design a DesignedHashMap without using any built-in hash table libraries.

 To be specific, your design should include these functions:

 put(key, value) : Insert a (key, value) pair into the DesignedHashMap. If the value already exists in the DesignedHashMap, update the value.
 get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 */
public class DesignedHashMap {
  final ListNode[] nodes = new ListNode[10000];

  public void put(int key, int value) {
    int i = getIdFromHashCode(key);
    if (nodes[i] == null) {
      nodes[i] = new ListNode(-1, -1);
    }
    ListNode prev = find(nodes[i], key);
    if (prev.next == null) {
      prev.next = new ListNode(key, value);
    } else {
      prev.next.val = value;
    }
  }

  public int get(int key) {
    int i = getIdFromHashCode(key);
    if (nodes[i] == null) {
      return -1;
    }
    ListNode node = find(nodes[i], key);
    return node.next == null ? -1 : node.next.val;
  }

  public void remove(int key) {
    int i = getIdFromHashCode(key);
    if (nodes[i] == null) {
      return;
    }
    ListNode prev = find(nodes[i], key);
    if (prev.next == null) {
      return;
    }
    prev.next = prev.next.next;
  }

  private int getIdFromHashCode(int key) {
    return Integer.hashCode(key) % nodes.length;
  }

  ListNode find(ListNode bucket, int key) {
    ListNode node = bucket;
    ListNode prev = null;
    while (node != null && node.key != key) {
      prev = node;
      node = node.next;
    }
    return prev;
  }

  class ListNode {
    int key, val;
    ListNode next;

    ListNode(int key, int val) {
      this.key = key;
      this.val = val;
    }
  }
}
