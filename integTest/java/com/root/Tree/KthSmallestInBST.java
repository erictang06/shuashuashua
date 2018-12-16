package com.root.Tree;

import com.root.common.TreeNode;


public class KthSmallestInBST {
  public int kthSmallest(TreeNode root, int k) {
    int numLeftChild = numChild(root.left);
    if (k <= numLeftChild) {
      return kthSmallest(root.left, k);
    }
    if (k > numLeftChild+1) {
      return kthSmallest(root.right, k-numLeftChild-1);
    }
    return root.val;
  }

  private int numChild(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return 1+numChild(root.left)+numChild(root.right);
  }
}
