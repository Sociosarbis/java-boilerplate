package runningSum;

public class Solution {
    public int[] runningSum(int[] nums) {
        int[] ret = new int[nums.length];
        ret[0] = nums[0];
        for (int i = 1;i < ret.length;i++) {
            ret[i] = ret[i - 1] + nums[i];
        }
        return ret;
    }
}
