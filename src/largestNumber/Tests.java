package largestNumber;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class Suite {
  int[] cost;
  int target;
  String ret;
  Suite(int[] cost, int target, String ret) {
    this.cost = cost;
    this.target = target;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = new Suite[]{
      new Suite(new int[]{ 4,3,2,5,6,7,2,5,5 }, 9, "7772"),
      new Suite(new int[]{ 7,6,5,5,5,6,8,7,8 }, 12, "85"),
      new Suite(new int[]{ 2,4,6,2,4,6,4,4,4 }, 5, "0"),
      new Suite(new int[]{ 6,10,15,40,40,40,40,40,40 }, 47, "32211")
    };

    Solution s = new Solution();
    for (Suite su:suites) {
      assertEquals(su.ret, s.largestNumber(su.cost, su.target));
    }
  }
}
