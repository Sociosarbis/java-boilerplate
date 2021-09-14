package containsNearbyAlmostDuplicate;

import java.util.List;
import java.util.ArrayList;
import utils.Utils;

public class Solution {
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums.length < 2 || k < 1) {
      return false;
    }
    List<Long> numList = new ArrayList<Long>(k + 1);
    numList.add(Long.valueOf(nums[0]));
    for (int i = 1;i < nums.length;i++) {
      int num = nums[i];
      if (numList.size() == k + 1) {
        numList.remove(Utils.binarySearch(numList, (long) nums[i - k - 1], false));
      }
      int j = Utils.binarySearch(numList, (long) num, true);
      if (j == 0) {
        if (Math.abs(numList.get(0) - num) <= t) {
          return true;
        }
      } else {
        if (j < numList.size()) {
          if (Math.abs(numList.get(j) - num) <= t) {
            return true;
          }
        }
        if (Math.abs(num - numList.get(j - 1)) <= t) {
          return true;
        }
      }
      if (j < numList.size()) {
        numList.add(j, Long.valueOf(num));
      } else {
        numList.add(Long.valueOf(num));
      }
    }
    return false;
  }
}
