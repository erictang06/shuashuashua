package com.root.Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class TopologicalSort {
  private int numNodes;
  private LinkedList<Integer>[] neighbors;

  public TopologicalSort(int size) {
    numNodes = size;
    neighbors = new LinkedList[size];
    for (int i=0; i<size; i++) {
      neighbors[i] = new LinkedList<>();
    }
  }

  private void addEdge(int v, int w) {
    neighbors[v].add(w);
  }

  private void topologicalSortUtil(int start, boolean[] visited, Stack<Integer> stack){
    visited[start] = true;
    Integer index;

    Iterator<Integer> iterator = neighbors[start].iterator();
    while (iterator.hasNext()) {
      index = iterator.next();
      if (!visited[index]) {
        topologicalSortUtil(index, visited, stack);
      }
    }
    stack.push(new Integer(start));
  }

  public void topologicalSort() {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[numNodes];

    for (int i=0; i< numNodes; i++) {
      if (!visited[i]) {
        topologicalSortUtil(i, visited, stack);
      }
    }

    while (!stack.isEmpty()) {
      System.out.println(stack.pop() + " ");
    }
  }

  public static void main(String[] args) {
    TopologicalSort g = new TopologicalSort(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);

    System.out.println("Following is a Topological " + "sort of the given graph");
    g.topologicalSort();
  }
}
