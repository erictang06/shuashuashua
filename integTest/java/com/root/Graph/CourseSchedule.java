package com.root.Graph;

import java.util.LinkedList;
import java.util.Queue;


/**
 There are a total of n courses you have to take, labeled from 0 to n-1.
 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */

public class CourseSchedule {
  public boolean topologicalSort(int numCourses, int[][] prerequisites) {
    int[][] edgeMatrix = new int[numCourses][numCourses];
    int[] incomingEdge = new int[numCourses];

    //build adj matrix
    for (int k = 0; k < prerequisites.length; k++) {
      // something like [ [1, 2], [2, 3] ]
      int pre = prerequisites[k][1];
      int ready = prerequisites[k][0];

      if (edgeMatrix[pre][ready] == 0) {
        incomingEdge[ready]++;
      }
      edgeMatrix[pre][ready] = 1;
    }

    //build queue for all nodes with no edges
    Queue<Integer> nodesWithNoEdges = new LinkedList<>();
    for (int i = 0; i < incomingEdge.length; i++) {
      if (incomingEdge[i] == 0) {
        nodesWithNoEdges.add(i);
      }
    }

    int courseCount = 0;

    //process queue
    while (!nodesWithNoEdges.isEmpty()) {
      int course = nodesWithNoEdges.poll();
      courseCount++;

      //go through adj matrix and start removing edges from i -> j
      for (int j = 0; j < edgeMatrix[0].length; j++) {
        if (edgeMatrix[course][j] != 0) { //edge found
          incomingEdge[j]--;  //remove edge

          if (incomingEdge[j] == 0) { //no edges left for this node
            nodesWithNoEdges.add(j);
          }
        }
      }
    }

    return courseCount == numCourses;
  }
}
