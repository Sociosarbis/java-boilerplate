package findErrorNums;

public class Solution {
  public int[] findErrorNums(int[] nums) {
    int n = nums.length;
    int duplicate = 0;
    int[] counts = new int[n + 1];
    int left = 1;
    for (int i = 2;i <= n;i++) {
      left ^= i;
    }

    for (int i = 0;i < n;i++) {
      left ^= nums[i];
      if (duplicate == 0) {
        counts[nums[i]] += 1;
        if (counts[nums[i]] > 1) {
          duplicate = nums[i];
        }
      }
    }
    return new int[]{ duplicate, left ^ duplicate};
  }
}
