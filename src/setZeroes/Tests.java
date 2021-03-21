package setZeroes;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

class Suite {
  int[][] matrix;
  int[][] ret;
  Suite(int[][] matrix, int[][] ret) {
    this.matrix = matrix;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = new Suite[] {
      // new Suite(new int[][]{{1,1,1},{1,0,1},{1,1,1}}, new int[][]{{1,0,1},{0,0,0},{1,0,1}}),
      // new Suite(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}}, new int[][]{{0,0,0,0},{0,4,5,0},{0,3,1,0}}),
      new Suite(new int[][]{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}}, new int[][]{{0,0,3,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}})
    };

    Solution s = new Solution();

    for (Suite su:suites) {
      s.setZeroes(su.matrix);
      assertArrayEquals(su.ret, su.matrix);
    }
  }
}
