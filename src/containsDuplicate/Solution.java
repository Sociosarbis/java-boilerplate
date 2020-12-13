package containsDuplicate;

import java.util.Set;
import java.util.HashSet;

class Solution {
  public boolean containsDuplicate(int[] nums) {
      Set<Integer> s = new HashSet<Integer>();
      for (int num:nums) {
          if (s.contains(num)) return true;
          s.add(num);
      }
      return false;
  }
}
