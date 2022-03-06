package goodDaysToRobBank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;


class Suite {
    int[] security;
    int time;
    List<Integer> ret;

    Suite(int[] security, int time, List<Integer> ret) {
        this.security = security;
        this.time = time;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite(new int[]{5,3,3,3,5,6,2}, 2, List.of(2,3)),
            new Suite(new int[]{1,1,1,1,1}, 0, List.of(0,1,2,3,4)),
            new Suite(new int[]{1,2,3,4,5,6}, 2, List.of()),
            new Suite(new int[]{1,2,3,4}, 1, List.of()),
            new Suite(new int[]{4,3,2,1}, 0, List.of(0,1,2,3))
        };

        Solution s = new Solution();
        for (var su: suites) {
            assertEquals(su.ret, s.goodDaysToRobBank(su.security, su.time));
        }
    }
}
