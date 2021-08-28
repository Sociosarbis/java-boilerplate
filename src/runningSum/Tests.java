package runningSum;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

class Suite {
    int[] nums;
    int[] ret;
    Suite(int[] nums, int[] ret) {
        this.nums = nums;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite(new int[]{1,2,3,4}, new int[]{1,3,6,10}),
            new Suite(new int[]{1,1,1,1,1}, new int[]{1,2,3,4,5}),
            new Suite(new int[]{3,1,2,10,1}, new int[]{3,4,6,16,17}),
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertArrayEquals(su.ret, s.runningSum(su.nums));
        }
    }
}
