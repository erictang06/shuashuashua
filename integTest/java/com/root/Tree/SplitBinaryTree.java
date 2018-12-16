package com.root.Tree;

import com.root.common.TreeNode;
import java.util.HashMap;
import java.util.Map;


public class SplitBinaryTree {
  /**
   * 1. split binary tree to two subtrees with same nodes sum

   example:
   10
   5        10
   2      3

   can be split into :
   10
   5
   and
   10
   2       3
   */

  public boolean equalTreePartition(TreeNode root) {
    /*
    The idea is to use a hash table to record all the different sums of each subtree in the tree.
    If the total sum of the tree is sum, we just need to check if the hash table constains sum/2.
    Reason why we want to have a special case of sum == 0, is because of special case {0, -1, 1}
    */
    Map<Integer, Integer> map = new HashMap<>();
    int sum = getSum(root, map);
    if (sum == 0) {
      return map.getOrDefault(sum, 0) > 1;
    }

    return sum % 2 == 0 && map.containsKey(sum / 2);
  }

  private int getSum(TreeNode root, Map<Integer, Integer> map) {
    if (root == null) {
      return 0;
    }

    int curSum = root.val + getSum(root.left, map) + getSum(root.right, map);
    map.put(curSum, map.getOrDefault(curSum, 0) + 1);
    return curSum;
  }
}
