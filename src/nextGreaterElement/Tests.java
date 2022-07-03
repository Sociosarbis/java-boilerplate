package nextGreaterElement;

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
            new Suite(12, 21),
            new Suite(21, -1)
        };

        var s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.nextGreaterElement(su.n));
        }
    }
}
