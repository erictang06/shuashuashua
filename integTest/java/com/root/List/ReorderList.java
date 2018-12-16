package com.root.List;

import com.root.common.ListNode;


/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList {
  public void reorderList(ListNode head) {
    if(head == null || head.next == null || head.next.next == null) {
      return;
    }
    //find middle and cut
    ListNode middle = findMiddle(head);
    ListNode secondHead = middle.next;
    middle.next = null;

    //reverse secondHead
    ListNode newSecondHead = reverseList(secondHead);

    //Merge two ListNode
    head = merge(head, newSecondHead);
  }

  private ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  private ListNode reverseList(ListNode head) {
    if(head == null ) {
      return null;
    }
    if(head.next == null) {
      return head;
    }
    ListNode secondElement = head.next;
    ListNode reverse = reverseList(secondElement);
    secondElement.next = head;
    head.next = null;
    return reverse;
  }

  private ListNode merge(ListNode head, ListNode secondHead) {
    if(head == null) {
      return secondHead;
    }
    if(secondHead == null) {
      return head;
    }
    head.next = merge(secondHead, head.next);
    return head;
  }
}
