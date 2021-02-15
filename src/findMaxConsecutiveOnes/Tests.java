package findMaxConsecutiveOnes;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


class Suite {
  int[] nums;
  int ret;
  Suite(int[] nums, int ret) {
    this.nums = nums;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = {
      new Suite(new int[]{ 1,1,0,1,1,1 }, 3)
    };
    Solution s = new Solution();
    for (Suite su:suites) {
      assertEquals(s.findMaxConsecutiveOnes(su.nums), su.ret);
    }
  }
}
