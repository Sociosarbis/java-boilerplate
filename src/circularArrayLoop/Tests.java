package circularArrayLoop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class Suite {
    int[] nums;
    boolean ret;
    Suite(int[] nums, boolean ret) {
        this.nums = nums;
        this.ret = ret;
    }
}

public class Tests {
    @Test
    public void testResults() {
        Suite[] suites = new Suite[]{
            new Suite(new int[]{2,-1,1,2,2}, true),
            new Suite(new int[]{-1,2}, false),
            new Suite(new int[]{-2,1,-1,-2,-2}, false),
            new Suite(new int[]{3,1,2}, true),
            new Suite(new int[]{5,-1,1,2,2}, false),
            new Suite(new int[]{-2,-3,-9}, false)
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.circularArrayLoop(su.nums));
        }
    }
}
