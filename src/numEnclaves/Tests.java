package numEnclaves;

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
        var suites = new Suite[]{
            new Suite(new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}}, 3),
            new Suite(new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}}, 0),
        };
        Solution s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.numEnclaves(su.grid));
        }
    }
}
