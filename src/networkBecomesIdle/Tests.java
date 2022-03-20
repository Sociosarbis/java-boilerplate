package networkBecomesIdle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    int[][] edges;
    int[] patience;
    int ret;
    Suite(int[][] edges, int[] patience, int ret) {
        this.edges = edges;
        this.patience = patience;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite(new int[][]{{0,1},{1,2}}, new int[]{0,2,1}, 8),
            new Suite(new int[][]{{0,1},{0,2},{1,2}}, new int[]{0,10,10}, 3),
        };

        Solution s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.networkBecomesIdle(su.edges, su.patience));
        }
    }
}
