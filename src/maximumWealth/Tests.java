package maximumWealth;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    int[][] account;
    int ret;
    Suite(int[][] account, int ret) {
        this.account = account;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResult() {
        var suites = new Suite[] {
            new Suite(new int[][]{
                {1,2,3},{3,2,1}
            }, 6),
            new Suite(new int[][]{
                {1,5},{7,3},{3,5}
            }, 10),
            new Suite(new int[][]{
                {2,8,7},{7,1,3},{1,9,5}
            }, 17),
        };

        Solution s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.maximumWealth(su.account));
        }
    }
}
