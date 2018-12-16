package com.root.common;

import java.util.LinkedList;
import java.util.List;


public class Graph {
  public int numNodes;
  public List<Integer>[] neighbors;

  public Graph(int size) {
    numNodes = size;
    initNeighbors();
  }

  public int getNumVertex() {
    return numNodes;
  }

  public List<Integer>[] getEdges() {
    return neighbors;
  }

  public void addEdge(int u, int v) {
    neighbors[u].add(v);
  }

  private void initNeighbors() {
    neighbors = new LinkedList[numNodes];
    for (int i=0; i<numNodes; i++) {
      neighbors[i] = new LinkedList<>();
    }
  }
}
