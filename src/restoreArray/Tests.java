package restoreArray;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

class Suite {
    public int[][] adjacentPairs;
    public int[] ret;

    public Suite(int[][] adjacentPairs, int[] ret) {
        this.adjacentPairs = adjacentPairs;
        this.ret = ret;
    }
}


public class Tests {
    @Test
    public void testResults() throws Exception {
      Solution s = new Solution();
      Suite suites[] = new Suite[]{
        new Suite(new int[][]{{2,1},{3,4},{3,2}}, new int[]{1,2,3,4}),
        new Suite(new int[][]{{4,-2},{1,4},{-3,1}}, new int[]{-2,4,1,-3}),
        new Suite(new int[][]{{100000,-100000}}, new int[]{100000,-100000}),
      };
      for (Suite su:suites) {
        assertArrayEquals(su.ret, s.restoreArray(su.adjacentPairs));
      }
    }
  }