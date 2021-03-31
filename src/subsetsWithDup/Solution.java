package subsetsWithDup;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    ret.add(new ArrayList<Integer>());
    for (int i = 0;i < nums.length;i++) {
      dfs(nums, i, temp, ret);
    }
    return ret;
  }

  void dfs(int[] nums, int i, List<Integer> temp, List<List<Integer>> ret) {
    if (i < nums.length) {
      int len = temp.size();
      temp.add(nums[i]);
      while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
        temp.add(nums[i + 1]);
        i += 1;
      }
      ret.add(new ArrayList<Integer>(temp));
      for (int j = i + 1;j < nums.length;j++) {
        dfs(nums, j, temp, ret);
      }
      while (temp.size() > len) {
        temp.remove(temp.size() - 1);
      }
    }
  }
}