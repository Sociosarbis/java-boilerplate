package getMaximumGold;

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
            new Suite(new int[][]{{0,6,0},{5,8,7},{0,9,0}}, 24),
            new Suite(new int[][]{{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}}, 28)
        };

        var s = new Solution();

        for (var su:suites) {
            assertEquals(su.ret, s.getMaximumGold(su.grid));
        }
    }
}
