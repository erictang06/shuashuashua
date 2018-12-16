package com.root.List;

import java.util.HashMap;
import java.util.Map;


/**
 * Design and implement a data structure for Least Recently Used (LRUCache) cache. It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {

//  private HashMap<Integer, LRUNode> cache = new HashMap<>();
//  private int capacity;
//  private int count;
//  LRUNode head;
//  LRUNode tail;
//
//  public LRUCache(int capacity) {
//    this.capacity = capacity;
//    this.count = 0;
//    head = new LRUNode();
//    head.prev = null;
//
//    tail = new LRUNode();
//    tail.next = null;
//
//    head.next = tail;
//    tail.prev = head;
//  }
//
//  public int get(int key) {
//    LRUNode lruNode = cache.get(key);
//    if (lruNode == null) {
//      return -1;
//    }
//
//    this.moveToHead(lruNode);
//    return lruNode.value;
//  }
//
//  public void put(int key, int value) {
//    LRUNode lruNode = cache.get(key);
//    if (lruNode == null) {
//      LRUNode newNode = new LRUNode();
//      newNode.key = key;
//      newNode.value = value;
//
//      this.cache.put(key, newNode);
//      this.addNode(newNode);
//
//      count++;
//      if (count > capacity) {
//        LRUNode tailNode = this.popTailNode();
//        this.cache.remove(tailNode);
//        count--;
//      }
//    } else {
//      lruNode.value = value;
//      this.moveToHead(lruNode);
//    }
//  }
//
//  private void addNode(LRUNode lruNode) {
//    lruNode.prev = head;
//    lruNode.next = head.next;
//
//    head.next.prev = lruNode;
//    head.next = lruNode;
//  }
//
//  private void removeNode(LRUNode lruNode) {
//    lruNode.prev.next = lruNode.next;
//    lruNode.next.prev = lruNode.prev;
//  }
//
//  private void moveToHead(LRUNode lruNode) {
//    this.removeNode(lruNode);
//    this.addNode(lruNode);
//  }
//
//  private LRUNode popTailNode() {
//    LRUNode lruNode = tail.prev;
//    this.removeNode(lruNode);
//    return lruNode;
//  }
//
//
//
//  class LRUNode {
//    int key;
//    int value;
//    LRUNode prev;
//    LRUNode next;
//  }
//

  int capacity;
  Map<Integer, Node> cache;
  Node head = null;
  Node tail = null;
  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<>(capacity);
    head = new Node(0,0);
    tail = new Node(0,0);
    head.post = tail;
    tail.pre = head;
  }


  public int get(int key) {
    int res = -1;
    if (cache.containsKey(key)) {
      Node n = cache.get(key);
      moveToHead(n);
      res = n.value;
    }
    return res;
  }

  public void put(int key, int value) {
    Node node = cache.get(key);

    if (cache.containsKey(key)) { // update the key and move to front
      node.value = value;
      this.moveToHead(node);
    } else {        // insert the key to the front after popTail (if full)
      if (cache.size() == capacity) {
        Node tail = this.popTail();
        cache.remove(tail.key);
      }
      Node newNode = new Node(key, value);
      this.addToHead(newNode);
      cache.put(key, newNode);
    }
  }

  // add node to the real-head, so the recent location
  private void addToHead(Node node) {
    node.pre = head;
    node.post = head.post;

    head.post.pre = node;
    head.post = node;
  }

  private void removeNode(Node node) {
    Node pre = node.pre;
    Node post = node.post;
    pre.post = post;
    post.pre = pre;
  }

  private void moveToHead(Node node) {
    this.removeNode(node);
    this.addToHead(node);
  }

  private Node popTail() {
    Node res = tail.pre;
    this.removeNode(res);
    return res;
  }

  class Node {
    int key;
    int value;
    Node pre;
    Node post;

    Node(int k, int v) {
      this.key = k;
      this.value = v;
    }
  }
}
