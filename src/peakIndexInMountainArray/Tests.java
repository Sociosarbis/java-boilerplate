package peakIndexInMountainArray;

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
  public void testResult() {
    Suite[] suites = new Suite[]{
      new Suite(new int[]{0,1,0}, 1),
      new Suite(new int[]{0,2,1,0},1),
      new Suite(new int[]{0,10,5,2}, 1),
      new Suite(new int[]{3,4,5,1},2),
      new Suite(new int[]{24,69,100,99,79,78,67,36,26,19}, 2),
    };

    Solution s = new Solution();
    for (Suite su:suites) {
      assertEquals(su.ret, s.peakIndexInMountainArray(su.arr));
    }
  }
}
