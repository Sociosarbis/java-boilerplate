package minCost;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class Suite {
  int[] houses;
  int[][] cost;
  int m;
  int n;
  int target;
  int ret;
  Suite (int[] houses, int[][] cost, int m, int n, int target, int ret) {
    this.houses = houses;
    this.cost = cost;
    this.m = m;
    this.n = n;
    this.target = target;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = new Suite[]{
      new Suite(new int[]{0,0,0,0,0}, new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}}, 5, 2, 3, 9),
      new Suite(new int[]{0,2,1,2,0}, new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}}, 5, 2, 3, 11),
      new Suite(new int[]{0,0,0,0,0}, new int[][]{{1,10},{10,1},{1,10},{10,1},{1,10}}, 5, 2, 5, 5),
      new Suite(new int[]{3,1,2,3}, new int[][]{{1,1,1},{1,1,1},{1,1,1},{1,1,1}}, 4, 3, 3, -1)
    };
    Solution s = new Solution();
    for (Suite su:suites) {
      assertEquals(su.ret, s.minCost(su.houses, su.cost, su.m, su.n, su.target));
    }
  }
}
