package maxTurbulenceSize;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

class Suite {
  int[] arr;
  int ret;
  Suite(int[] arr, int ret) {
    this.arr = arr;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Solution s = new Solution();
    Suite[] suites = {
      new Suite(new int[]{9,4,2,10,7,8,8,1,9}, 5),
      new Suite(new int[]{4,8,12,16}, 2),
      new Suite(new int[]{100}, 1),
    };

    for (Suite su:suites) {
      assertEquals(su.ret, s.maxTurbulenceSize(su.arr));
    }
  }
}
