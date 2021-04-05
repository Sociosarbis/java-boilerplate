package merge;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

class Suite {
  int[] nums1;
  int m;
  int[] nums2;
  int n;
  int[] ret;
  Suite(int[] nums1, int m, int[] nums2, int n, int[] ret) {
    this.nums1 = nums1;
    this.m = m;
    this.nums2 = nums2;
    this.n = n;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = {
      new Suite(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3, new int[]{1,2,2,3,5,6}),
      new Suite(new int[]{1}, 1, new int[]{}, 0, new int[]{1})
    };
    Solution s = new Solution();
    for (Suite su:suites) {
      s.merge(su.nums1, su.m, su.nums2, su.n);
      assertArrayEquals(su.ret, su.nums1);
    }
  }
}
