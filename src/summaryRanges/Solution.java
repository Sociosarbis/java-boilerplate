package summaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> ret = new ArrayList<String>();
    if (nums.length == 0) return ret;
    int l = nums[0];
    int r = nums[0];
    for (int i = 1;i < nums.length;i++) {
      if (nums[i] != r && r + 1 != nums[i]) {
        ret.add(l != r ? String.format("%d->%d", l, r) : String.format("%d", l));
        l = nums[i];
        r = nums[i];
      } else if (nums[i] - r == 1) {
        r = nums[i];
      }
    }
    ret.add(l != r ? String.format("%d->%d", l, r) : String.format("%d", l));
    return ret;
  }
}
