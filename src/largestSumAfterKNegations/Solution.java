package largestSumAfterKNegations;

import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        for (;i < nums.length;i++) {
            if (k == 0 || nums[i] >= 0) break;
            nums[i] = -nums[i];
            k--;
        }
        if ((k & 1) != 0) {
            if (i >= nums.length) {
                i = nums.length - 1;
            }
            if (i > 0 && nums[i - 1] < nums[i]) {
                nums[i - 1] = -nums[i - 1];
            } else {
                nums[i] = -nums[i];
            }
        }
        int ret = 0;
        for (i = 0;i < nums.length;i++) {
            ret += nums[i];
        }
        return ret;
    }
}