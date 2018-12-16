package com.root.Tree;

import com.root.common.ListNode;
import com.root.common.TreeNode;


public class ConvertSortedListToBST {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }

    return helper(head, null);
  }

  private TreeNode helper(ListNode head, ListNode tail) {
    if (head == tail) {
      return null;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast != tail && fast.next != tail) {
      fast = fast.next.next;
      slow = slow.next;
    }

    TreeNode root = new TreeNode(slow.val);
    root.left = helper(head, slow);
    root.right = helper(slow.next, tail);

    return root;
  }
}
