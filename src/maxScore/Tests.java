package maxScore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    String s;
    int ret;
    Suite(String s, int ret) {
        this.s = s;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite("011101", 5),
            new Suite("00111", 5),
            new Suite("1111", 3),
        };

        var s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.maxScore(su.s));
        }
    }
}
