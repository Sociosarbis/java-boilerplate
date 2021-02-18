package minKBitFlips;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
  int[] A;
  int k;
  int ret;
  Suite(int[] A, int k, int ret) {
    this.A = A;
    this.k = k;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = {
      new Suite(new int[]{0,1,0}, 1, 2),
      new Suite(new int[]{1,1,0}, 2, -1),
      new Suite(new int[]{0,0,0,1,0,1,1,0}, 3, 3),
    };
    Solution s = new Solution();
    for (Suite su:suites) {
      assertEquals(su.ret, s.minKBitFlips(su.A, su.k));
    }
  }
}
