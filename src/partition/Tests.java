package partition;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

class Suite {
  List<Integer> head;
  int x;
  List<Integer> ret;
  public Suite(List<Integer> head, int x, List<Integer> ret) {
    this.head = head;
    this.x = x;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() throws Exception {
    Solution s = new Solution();
    Suite[] suites = new Suite[] {
      new Suite(Arrays.asList(1,4,3,2,5,2), 3, Arrays.asList(1,2,2,4,3,5)),
      new Suite(Arrays.asList(1,1), 0, Arrays.asList(1,1))
    };
    for (Suite su:suites) {
      assertEquals(su.ret, linkedListToArr(s.partition(arrToLinkedList(su.head), su.x)));
    }
  }

  private ListNode arrToLinkedList(List<Integer> head) {
    if (head.isEmpty()) {
      return null;
    } else {
      ListNode h = new ListNode(head.get(0));
      ListNode t = h;
      for (int i = 1;i < head.size();i++) {
        t.next = new ListNode(head.get(i));
        t = t.next;
      }
      return h;
    }
  }

  private List<Integer> linkedListToArr(ListNode head) {
    List<Integer> ret = new ArrayList<Integer>();
    ListNode cur = head;
    while (cur != null) {
      ret.add(cur.val);
      cur = cur.next;
    }
    return ret;
  }
}
