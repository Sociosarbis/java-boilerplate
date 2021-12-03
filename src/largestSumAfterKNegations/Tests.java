package largestSumAfterKNegations;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
    int[] nums;
    int k;
    int ret;
    Suite(int[] nums, int k, int ret) {
        this.nums = nums;
        this.k = k;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite(new int[]{4,2,3}, 1, 5),
            new Suite(new int[]{3,-1,0,2}, 3, 6),
            new Suite(new int[]{2,-3,-1,5,-4}, 2, 13)
        };
        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.largestSumAfterKNegations(su.nums, su.k));
        }
    }
}
