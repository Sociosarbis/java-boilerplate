package totalMoney;

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
        Suite[] suites = new Suite[]{
            new Suite(4, 10),
            new Suite(10, 37),
            new Suite(20, 96)
        };

        Solution s = new Solution();

        for (Suite su:suites) {
            assertEquals(su.ret, s.totalMoney(su.n));
        }
    }
}
