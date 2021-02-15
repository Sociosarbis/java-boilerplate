package findMaxConsecutiveOnes;

public class Solution {
  public int findMaxConsecutiveOnes(int[] nums) {
    int tmp = 0;
    int ret = 0;
    for (int i = 0;i < nums.length;i++) {
      if (nums[i] == 1) {
        tmp += 1;
        if (tmp > ret) {
          ret = tmp;
        }
      } else {
        tmp = 0;
      }
    }
    return ret;
  }
}
