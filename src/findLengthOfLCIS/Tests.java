package findLengthOfLCIS;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

class Suite {
  int[] nums;
  int ret;
  public Suite(int[] nums, int ret) {
    this.nums = nums;
    this.ret = ret;
  }
}

public class Tests {

  @Test
  public void testResults() {
    Suite[] suites = new Suite[] {
      new Suite(new int[]{1,3,5,4,7}, 3),
      new Suite(new int[]{2,2,2,2,2}, 1),
    };

    Solution s =  new Solution();

    for (Suite suite:suites) {
      assertEquals(suite.ret, s.findLengthOfLCIS(suite.nums));
    }
  }
}
