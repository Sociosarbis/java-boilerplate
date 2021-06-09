package profitableSchemes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

class Suite {
  int n;
  int minProfit;
  int[] group;
  int[] profit;
  int ret;
  Suite(int n, int minProfit, int[] group, int[] profit, int ret) {
    this.n = n;
    this.minProfit = minProfit;
    this.group = group;
    this.profit = profit;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = new Suite[]{
      new Suite(5, 3, new int[]{2,2}, new int[]{2,3}, 2),
      new Suite(10, 5, new int[]{2,3,5}, new int[]{6, 7, 8}, 7),
      new Suite(1, 1, new int[]{1,1,1,1,2,2,1,2,1,1}, new int[]{0,1,0,0,1,1,1,0,2,2}, 4),
    };

    Solution s = new Solution();
    for (Suite su:suites) {
      assertEquals(su.ret, s.profitableSchemes(su.n, su.minProfit, su.group, su.profit));
    }
  }
}
