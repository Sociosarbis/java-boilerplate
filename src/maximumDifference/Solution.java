package maximumDifference;

public class Solution {
    public int maximumDifference(int[] nums) {
        var ret = -1;
        var temp = nums[0];
        for (var i = 1;i < nums.length;i++) {
            if (nums[i] > temp) {
                if (nums[i] - temp > ret) {
                    ret = nums[i] - temp;
                }
            } else if (nums[i] < temp) {
                temp = nums[i];
            }
            
        }
        return ret;
    }
}
