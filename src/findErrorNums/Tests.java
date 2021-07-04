package findErrorNums;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

class Suite {
  int[] nums;
  int[] ret;
  Suite(int[] a, int[] b) {
    nums = a;
    ret = b;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = new Suite[]{
      new Suite(
        new int[]{1,2,2,4},
        new int[]{2,3}
      ),
      new Suite(
        new int[]{1,1},
        new int[]{1, 2}
      )
    };

    Solution s = new Solution();

    for (Suite su:suites) {
      assertArrayEquals(su.ret, s.findErrorNums(su.nums));
    }
  }
}
