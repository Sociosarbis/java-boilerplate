package thirdMax;

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
        Suite suites[] = new Suite[]{
            /*new Suite(
                new int[]{ 3, 2, 1 },
                1
            ),
            new Suite(
                new int[]{ 1, 2 },
                2
            ),
            new Suite(
                new int[]{ 2, 2, 3, 1 },
                1
            ),*/
            new Suite(
                new int[]{2,0,3,2}, 
            0)
        };

        Solution s = new Solution();
        for (Suite su:suites) {
            assertEquals(su.ret, s.thirdMax(su.nums));
        }
    }
}
