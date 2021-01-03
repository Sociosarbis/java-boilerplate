package partition;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode l1Head = null;
    ListNode l1Tail = null;
    ListNode l2Head = null;
    ListNode l2Tail = null;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val >= x) {
        if (l2Head == null) {
          l2Head = cur;
          l2Tail = cur;
        } else {
          l2Tail.next = cur;
          l2Tail = cur;
        }
      } else {
        if (l1Head == null) {
          l1Head = cur;
          l1Tail = cur;
        } else {
          l1Tail.next = cur;
          l1Tail = cur;
        }
      }
      cur = cur.next;
    }

    if (l1Tail != null && l2Head != null) {
      l1Tail.next = l2Head;
      l2Tail.next = null;
      return l1Head;
    } else {
      if (l1Tail == null) {
        return l2Head;
      } else {
        return l1Head;
      }
    }
  }
}
