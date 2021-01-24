package findLengthOfLCIS;

public class Solution {
  public int findLengthOfLCIS(int[] nums) {
    if (nums.length == 0) return  0;
    int ret = 1;
    int tmp = 1;
    for (int i = 1;i < nums.length;i++) {
      if (nums[i] > nums[i - 1])  {
        tmp++;
      } else {
        if (tmp > ret) {
          ret = tmp;
        }
        tmp = 1;
      }
    }
    if (tmp > ret) {
      ret = tmp;
    }
    return ret;
  }
}
