package com.root.List;

import com.root.common.ListNode;


public class ReverseLinkedList {
  public ListNode reverseListIterative(ListNode head) {
    /* iterative solution */
    ListNode newHead = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;
  }

  public ListNode reverseListRecursive(ListNode head) {
    /* recursive solution */
    return reverseListInt(head, null);
  }

  private ListNode reverseListInt(ListNode head, ListNode newHead) {
    if (head == null)
      return newHead;
    ListNode next = head.next;
    head.next = newHead;
    return reverseListInt(next, head);
  }

  public ListNode reverseList(ListNode head) {
    if(head==null || head.next==null)
      return head;
    ListNode nextNode=head.next;
    ListNode newHead=reverseList(nextNode);
    nextNode.next=head;
    head.next=null;
    return newHead;
  }
}
