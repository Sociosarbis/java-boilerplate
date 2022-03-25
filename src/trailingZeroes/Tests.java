package trailingZeroes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    int n;
    int ret;
    Suite(int n, int ret) {
        this.n = n;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite(3, 0),
            new Suite(5, 1),
            new Suite(0, 0)
        };

        Solution s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.trailingZeroes(su.n));
        }
    }
}
