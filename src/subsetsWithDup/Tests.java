package subsetsWithDup;

import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

class Suite {
  int[] nums;
  List<List<Integer>> ret;
  Suite(int[] nums, List<List<Integer>> ret) {
    this.nums = nums;
    this.ret = ret;
  }
}


public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = new Suite[] {
      new Suite(new int[] {1,2,2}, Arrays.asList(Arrays.asList(), Arrays.asList(1),Arrays.asList(1,2,2),Arrays.asList(1,2),Arrays.asList(2,2),Arrays.asList(2))),
      new Suite(new int[] {0}, Arrays.asList(Arrays.asList(), Arrays.asList(0)))
    };

    Solution s = new Solution();

    for (Suite su:suites) {
      assertEquals(su.ret, s.subsetsWithDup(su.nums));
    }
  }
}
