package checkStraightLine;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

class Suite {
  int[][] coordinates;
  boolean ret;
  Suite(int[][] coordinates, boolean ret) {
    this.coordinates = coordinates;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() throws Exception {
    Solution s = new Solution();
    Suite[] suites = {
      new Suite(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}, true),
      new Suite(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}, false),
    };
    for (Suite su: suites) {
      assertEquals(su.ret, s.checkStraightLine(su.coordinates));
    }
  }
}
