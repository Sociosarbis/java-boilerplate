package containsNearbyAlmostDuplicate;

import java.util.List;
import java.util.ArrayList;

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
        numList.remove(binarySearch(numList, nums[i - k - 1], false));
      }
      int j = binarySearch(numList, num, true);
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

  int binarySearch(List<Long> nums, int target, boolean isInsert) {
    if (nums.isEmpty()) {
      return isInsert ? 0 : -1;
    }

    int l = 0;
    int r = nums.size() - 1;
    while (l <= r) {
      int mid  = (l + r) / 2;
      if (nums.get(mid) < target) {
        l = mid + 1;
        if (l > r) {
          return isInsert ? l : -1;
        }
      } else if (nums.get(mid) > target) {
        if (mid == 0 || mid - 1 < l) {
          return isInsert ? mid : -1;
        }
        r = mid - 1;
      } else {
        return mid;
      }
    }
    return 0;
  }
}
