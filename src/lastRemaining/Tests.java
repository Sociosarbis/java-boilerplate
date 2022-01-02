package lastRemaining;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    int n;
    int ret;
    Suite (int n, int ret) {
        this.n = n;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite(9, 6),
            new Suite(1, 1)
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.lastRemaining(su.n));
        }
    }
}
