package circularArrayLoop;

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0;i <nums.length; i++) {
            while (nums[i] <= 1000 && nums[i] >= -1000) {
                if (nums[i] > nums.length) {
                    nums[i] %= nums.length;
                    if (nums[i] == 0) {
                        nums[i] = nums.length;
                    }
                } else if (nums[i] < nums.length) {
                    nums[i] %= nums.length;
                    if (nums[i] == 0) {
                        nums[i] = -nums.length;
                    }
                }
                int nextI = i + nums[i];
                if (nextI < 0) {
                    nextI += nums.length;
                } else if (nextI >= nums.length) {
                    nextI -= nums.length;
                }
                if (nums[i] < 0) {
                    nums[i] += 3001;
                } else {
                    nums[i] += 1000;
                }
                i = nextI;
            }
            int count = 0;
            int originI = i;
            boolean isPositive = nums[i] <= 2000;
            do {
                int val = nums[i];
                if (val < -1000) {
                    count = 0;
                    break;
                }
                nums[i] = -1001;
                boolean curPositive = val <= 2000;
                if (curPositive != isPositive) {
                    count = 0;
                    break;
                }
                count += 1;
                i = i + (curPositive ? val - 1000 : val - 3001);
                if (i < 0) {
                    i += nums.length;
                } else if (i >= nums.length) {
                    i -= nums.length;
                }
            } while (i != originI);
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}