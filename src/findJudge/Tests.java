package findJudge;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    int n;
    int[][] trust;
    int ret;
    Suite(int n, int[][] trust, int ret) {
        this.n = n;
        this.trust = trust;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite(2, new int[][]{{1,2}}, 2),
            new Suite(3, new int[][]{{1,3},{2,3}},3),
            new Suite(3, new int[][]{{1,3},{2,3},{3,1}},-1)
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.findJudge(su.n, su.trust));
        }
    }
}
