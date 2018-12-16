package com.root.Graph;

import com.root.common.Graph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Traversal {

  public List<Integer> BFS(Graph g, int start) {
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[g.numNodes];
    LinkedList<Integer> queue = new LinkedList<>();

    visited[start] = true;
    queue.offer(start);

    while (queue.size() != 0) {
      start = queue.poll();
      result.add(start);

      Iterator<Integer> iter = g.neighbors[start].listIterator();
      while (iter.hasNext()) {
        int n = iter.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.offer(n);
        }
      }
    }

    return result;
  }

  public List<Integer> DFS(Graph g, int start) {
    boolean visited[] = new boolean[g.numNodes];
    List<Integer> result = new ArrayList<>();
    DFSUtil(g, result, visited, start);
    return result;
  }

  private void DFSUtil(Graph g, List<Integer> list, boolean[] visited, int start) {
    visited[start] = true;
    list.add(start);

    Iterator<Integer> iter = g.neighbors[start].listIterator();
    while (iter.hasNext()) {
      int node = iter.next();
      if (visited[node] != true) {
        DFSUtil(g, list, visited, node);
      }
    }
  }
}
