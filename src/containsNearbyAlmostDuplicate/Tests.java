package containsNearbyAlmostDuplicate;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
  int[] nums;
  int k;
  int t;
  boolean ret;
  Suite(int[] nums, int k, int t, boolean ret) {
    this.nums = nums;
    this.k = k;
    this.t = t;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() throws Exception {
    Suite[] suites = new Suite[]{
      new Suite(
        new int[]{1,2,3,1},
        3,
        0,
        true
      ),
      new Suite(
        new int[]{1,0,1,1},
        1,
        2,
        true
      ),
      new Suite(
        new int[]{1,5,9,1,5,9},
        2,
        3,
        false
      )
    };

    Solution s = new Solution();
    for (Suite su: suites) {
      assertEquals(su.ret, s.containsNearbyAlmostDuplicate(su.nums, su.k, su.t));
    }
  }
}
