package isMonotonic;

import org.junit.Test;
import static org.junit.Assert.assertEquals;



class Suite {
  int[] A;
  boolean ret;
  Suite(int[] A, boolean ret) {
    this.A = A;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = {
      new Suite(new int[]{ 1,2,2,3 }, true),
      new Suite(new int[]{ 6,5,4,4 }, true),
      new Suite(new int[]{ 1,3,2 }, false),
      new Suite(new int[]{ 1,2,4,5 }, true),
      new Suite(new int[]{ 1,1,1 }, true)
    };
    Solution s = new Solution();
    for (Suite su:suites) {
      assertEquals(s.isMonotonic(su.A), su.ret);
    }
  }
}
