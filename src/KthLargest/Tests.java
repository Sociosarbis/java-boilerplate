package KthLargest;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

class Suite {
  int k;
  int[] nums;
  Integer[] ret;
  int[] addNums;
  Suite(int k, int[] nums, int[] addNums, Integer[] ret) {
    this.k = k;
    this.nums = nums;
    this.addNums = addNums;
    this.ret = ret;
  }
}


public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = {
      new Suite(
        3,
        new int[] { 4, 5, 8, 2},
        new int[] { 3, 5, 10, 9, 4},
        new Integer[] { null, 4, 5, 5, 8, 8 }
      ),
    };
    for (Suite su: suites) {
      KthLargest k = new KthLargest(su.k, su.nums);
      Integer[] ret = new Integer[su.ret.length];
      for (int i = 0;i < su.addNums.length;i++) {
        ret[i + 1] = k.add(su.addNums[i]);
      }
      assertArrayEquals(su.ret, ret);
    }
  }
}
