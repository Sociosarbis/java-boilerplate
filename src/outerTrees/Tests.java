package outerTrees;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

class Suite {
    int[][] trees;
    int[][] ret;
    Suite(int[][] trees, int[][] ret) {
        this.trees = trees;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite(
                new int[][]{{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}},
                new int[][]{{2,0},{1,0},{2,4},{3,3},{4,2}}
            ),
            new Suite(
                new int[][]{{1,2},{2,2},{4,2}},
                new int[][]{{1,2},{2,2},{4,2}}
            ),
        };

        var s = new Solution();
        for (var su:suites) {
            assertArrayEquals(su.ret, s.outerTrees(su.trees));
        }
    }
}
