package maximumDifference;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


class Suite {
    int[] nums;
    int ret;
    Suite(int[] nums, int ret) {
        this.nums = nums;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        var suites = new Suite[]{
            new Suite(new int[]{7,1,5,4}, 4),
            new Suite(new int[]{9,4,3,2}, -1)
        };

        var s = new Solution();
        for (var su:suites) {
            assertEquals(su.ret, s.maximumDifference(su.nums));
        }
    }
}
