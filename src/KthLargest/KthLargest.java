package KthLargest;

import java.util.List;
import java.util.LinkedList;
import utils.Utils;

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
    return Utils.binarySearch(nums, target, isInsert);
  }
}
