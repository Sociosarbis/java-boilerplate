package snakesAndLadders;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class Suite {
  int[][] board;
  int ret;

  Suite(int[][] board, int ret) {
    this.board = board;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = new Suite[] {
        new Suite(new int[][] {
          { -1, -1, -1, -1, -1, -1 },
          { -1, -1, -1, -1, -1, -1 },
          { -1, -1, -1, -1, -1, -1 },
          { -1, 35, -1, -1, 13, -1 },
          { -1, -1, -1, -1, -1, -1 },
          { -1, 15, -1, -1, -1, -1 }
        }, 4),
        new Suite(new int[][] { 
          { -1, -1, 2, 21, -1 }, 
          { 16, -1, 24, -1, 4 }, 
          { 2, 3, -1, -1, -1 },
          { -1, 11, 23, 18, -1 }, 
          { -1, -1, -1, 23, -1 }
        }, 2) };

    Solution s = new Solution();
    for (Suite su : suites) {
      assertEquals(su.ret, s.snakesAndLadders(su.board));
    }
  }
}
