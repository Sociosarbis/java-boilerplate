package KthLargest;

import java.util.List;
import java.util.LinkedList;

public class KthLargest {
  List<Integer> nums;
  int k;
  public KthLargest(int k, int[] nums) {
    this.k = k;
    this.nums = new LinkedList<Integer>();
    for (int num: nums) {
      this.nums.add(num);
    }
    this.nums.sort(null);
  }
  
  public int add(int val) {
    if (k >= nums.size() || val > nums.get(nums.size() - k)) {
        if (k < nums.size() && val >= nums.get(nums.size() - 1)) {
          nums.add(val);
        } else {
          int index = binarySearch(val, true);
          nums.add(index, val);
        }
    }
    return nums.get(nums.size() - k);
  }

  int binarySearch(int target, boolean isInsert) {
    if (nums.isEmpty()) {
      return isInsert ? 0 : -1;
    }

    int l = nums.size() - k;
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
