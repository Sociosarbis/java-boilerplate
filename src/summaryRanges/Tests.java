package summaryRanges;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

class Suite {
  int[] nums;
  List<String> ret;
  
  Suite(int[] nums, List<String> ret) {
    this.nums = nums;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() throws Exception {
    Solution s = new Solution();
    Suite[] suites = new Suite[]{
      new Suite(new int[]{ 0,1,2,4,5,7 }, Arrays.asList("0->2","4->5","7")),
      new Suite(new int[]{0,2,3,4,6,8,9}, Arrays.asList("0","2->4","6","8->9")),
      new Suite(new int[]{}, new ArrayList<String>()),
      new Suite(new int[]{-1}, Arrays.asList("-1")),
      new Suite(new int[]{-2147483648,-2147483647,2147483647}, Arrays.asList("-2147483648->-2147483647","2147483647"))
    };

    for (Suite suite:suites) {
      assertEquals(suite.ret, s.summaryRanges(suite.nums));
    }
  }
}
