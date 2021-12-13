package maxIncreaseKeepingSkyline;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    int[][] grid;
    int ret;
    Suite(int[][] grid, int ret) {
        this.grid = grid;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}, 35),
            new Suite(new int[][]{{0,0,0},{0,0,0},{0,0,0}}, 0),
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.maxIncreaseKeepingSkyline(su.grid));
        }
    }
}
